
package com.porfolio.crud.controllers;

import com.porfolio.crud.Model.EduModel;
import com.porfolio.crud.Servicios.EduService;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/educacion")
public class EduController {
    
    @Autowired
    private EduService EduService;

    @CrossOrigin
    @GetMapping
    @ResponseBody
    public ArrayList<EduModel> getEdu(){
        return this.EduService.getEdu();
    }
    
    
    @PostMapping
    public EduModel saveEdu(@RequestBody EduModel edu){
        return this.EduService.saveEdu(edu);
    }

    @CrossOrigin
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping(path = "/{id}")
    public ResponseEntity<EduModel> putEdu(
            @RequestBody EduModel request,
            @PathVariable Long id){
        Optional <EduModel> edu = EduService.getById(request.getId());
        
         if (!edu.isPresent()){
            return ResponseEntity.notFound().build();
        }

        BeanUtils.copyProperties(request,edu.get());

        EduService.saveEdu(edu.get());

        return ResponseEntity.ok(edu.get());
    }

    @CrossOrigin
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity <Boolean> deleteById(@PathVariable("id") Long id) {

        return ResponseEntity.ok(EduService.deleteEdu(id));

    }
}
