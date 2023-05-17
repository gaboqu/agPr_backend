
package com.porfolio.crud.controllers;

import com.porfolio.crud.Model.EduModel;
import com.porfolio.crud.Servicios.EduService;
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
@RequestMapping("/educacion")
public class EduController {
    
    @Autowired
    private EduService EduService;
    
    @GetMapping
    @ResponseBody
    public ArrayList<EduModel> getEdu(){
        return this.EduService.getEdu();
    }
    
    
    @PostMapping
    public EduModel saveEdu(@RequestBody EduModel edu){
        return this.EduService.saveEdu(edu);
    }
    
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
}
