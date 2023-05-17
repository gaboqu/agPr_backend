
package com.porfolio.crud.Servicios;

import com.porfolio.crud.Model.ProyModel;
import com.porfolio.crud.Repository.IProyRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyService {
    
    @Autowired
    IProyRepository proyRepository;
    
     public ArrayList<ProyModel> getProy(){
        return (ArrayList<ProyModel>) proyRepository.findAll();
    }
    
    public ProyModel saveProy(ProyModel proy){
        return  proyRepository.save(proy);
    }
    
    public Optional<ProyModel> getById(Long id){
        return proyRepository.findById(id);
    }
    
    public ProyModel updateById(ProyModel request, Long id){
        ProyModel proy = proyRepository.findById(id).get();
        
       proy.setImg(request.getImg());
        proy.setTitulo(request.getTitulo());
        proy.setTitulo(request.getTitulo());
        proy.setTecnologias(request.getTecnologias());
        proy.setInfo(request.getInfo());
        
        return proy;
    }
    
    public Boolean deleteProy (Long id){
        try{
            proyRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }
            
            
    
}
