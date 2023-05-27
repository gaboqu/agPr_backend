
package com.porfolio.crud.controllers;

import com.porfolio.crud.Model.SkillModel;
import com.porfolio.crud.Servicios.SkillService;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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


    @CrossOrigin
    @PreAuthorize("hasRole('ADMIN')")
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

    @CrossOrigin
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity <Boolean> deleteById(@PathVariable("id") Long id) {

        return ResponseEntity.ok(SkillService.deleteSkill(id));

    }
    
}
