
package com.porfolio.crud.Servicios;

import com.porfolio.crud.Model.PersonaModel;
import com.porfolio.crud.Repository.IPersonaRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService {
    
    @Autowired
    IPersonaRepository PersonaRepository;
    
    public ArrayList<PersonaModel> getPersonas(){
        return (ArrayList<PersonaModel>) PersonaRepository.findAll();
    }
    
    public PersonaModel savePersona(PersonaModel persona){
        return PersonaRepository.save(persona);
    }
    
    public Optional<PersonaModel> getById(Long id){
        return PersonaRepository.findById(id);
    }
    
    public PersonaModel updateById(PersonaModel request, Long id){
        PersonaModel persona = PersonaRepository.findById(id).get();
        
        persona.setNombre(request.getNombre());
        persona.setDescripcion(request.getDescripcion());
        persona.setUrl_foto(request.getUrl_foto());
        persona.setEmail(request.getEmail());
        persona.setPassword(request.getPassword());
        persona.setFrase1(request.getFrase1());
        persona.setFrase2(request.getFrase2());
        
        return persona;
    }
    
    public Boolean deletePersona (Long id){
        try{
            PersonaRepository.deleteById(id);
                    return true;
        }catch(Exception e){
            return false;
        }
    }
    
}
