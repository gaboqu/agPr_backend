
package com.porfolio.crud.controllers;
import com.porfolio.crud.Model.ProyModel;
import com.porfolio.crud.Servicios.ProyService;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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

    @CrossOrigin
    @PreAuthorize("hasRole('ADMIN')")
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

    @CrossOrigin
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity <Boolean> deleteById(@PathVariable("id") Long id) {

        return ResponseEntity.ok(ProyService.deleteProy(id));

    }
    
}
