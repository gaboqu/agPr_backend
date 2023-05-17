
package com.porfolio.crud.controllers;

import com.porfolio.crud.Model.PersonaModel;
import com.porfolio.crud.Servicios.PersonaService;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona")
public class PersonaController {
    
    @Autowired
    private PersonaService PersonaService;
     
    @GetMapping
    @ResponseBody
    public ArrayList<PersonaModel> getPersonas(){
        return this.PersonaService.getPersonas();
    }
    
    @PostMapping
    public PersonaModel savePersona(@RequestBody PersonaModel persona){
        return this.PersonaService.savePersona(persona);
    }
    
    @GetMapping(path ="/{id}")
    public Optional<PersonaModel> getPersonaById(@PathVariable Long id){
        return this.PersonaService.getById(id);
    }
    @CrossOrigin
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping(path = "/{id}")
    public ResponseEntity<PersonaModel> putPersona(
            @RequestBody PersonaModel request,
            @PathVariable Long id){
        Optional <PersonaModel> persona = PersonaService.getById(request.getId());
        
         if (!persona.isPresent()){
            return ResponseEntity.notFound().build();
        }

        BeanUtils.copyProperties(request,persona.get());

        PersonaService.savePersona(persona.get());

        return ResponseEntity.ok(persona.get());
    }

    
    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id){
        boolean ok= this.PersonaService.deletePersona(id);
        
        if(ok){
            return "El Usuario  id " + id + " ha sido borrado!";
        }else{
            return "El Usuario id " + id + " no existe";
        }
    }
    
}
