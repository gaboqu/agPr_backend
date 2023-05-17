
package com.porfolio.crud.controllers;

import com.porfolio.crud.Model.SkillModel;
import com.porfolio.crud.Servicios.SkillService;
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
@RequestMapping("/skills")
public class SkillController {
    
    @Autowired
    private SkillService SkillService;
    
    @GetMapping
    @ResponseBody
    public ArrayList<SkillModel> getSkill(){
        return this.SkillService.getSkill();
    }
    
    
    @PostMapping
    public SkillModel saveSkill(@RequestBody SkillModel skill){
        return this.SkillService.saveSkill(skill);
    }
    
     @PutMapping(path = "/{id}")
    public ResponseEntity<SkillModel> putSkill(
            @RequestBody SkillModel request,
            @PathVariable Long id){
        Optional <SkillModel> skill = SkillService.getById(request.getId());
        
         if (!skill.isPresent()){
            return ResponseEntity.notFound().build();
        }

        BeanUtils.copyProperties(request,skill.get());

        SkillService.saveSkill(skill.get());

        return ResponseEntity.ok(skill.get());
    }
    
}
