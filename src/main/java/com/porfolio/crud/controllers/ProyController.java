
package com.porfolio.crud.controllers;

import com.porfolio.crud.Model.ProyModel;
import com.porfolio.crud.Servicios.ProyService;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proyectos")
public class ProyController {
    
    @Autowired
    private ProyService ProyService;
    
    @GetMapping
    @ResponseBody
    public ArrayList<ProyModel> getProy(){
        return this.ProyService.getProy();
    }
    
    
    @PostMapping
    public ProyModel saveProy(@RequestBody ProyModel proy){
        return this.ProyService.saveProy(proy);
    }
    
     @PutMapping(path = "/{id}")
    public ResponseEntity<ProyModel> putProy(
            @RequestBody ProyModel request,
            @PathVariable Long id){
        Optional <ProyModel> proy = ProyService.getById(request.getId());
        
         if (!proy.isPresent()){
            return ResponseEntity.notFound().build();
        }

        BeanUtils.copyProperties(request,proy.get());

        ProyService.saveProy(proy.get());

        return ResponseEntity.ok(proy.get());
    }
    
}
