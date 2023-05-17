
package com.porfolio.crud.Servicios;

import com.porfolio.crud.Model.SkillModel;
import com.porfolio.crud.Repository.ISkRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService {
    
    @Autowired
    ISkRepository skRepository;
    
    public ArrayList<SkillModel> getSkill(){
        return (ArrayList<SkillModel>) skRepository.findAll();
    }
    
    public SkillModel saveSkill(SkillModel skill){
        return  skRepository.save(skill);
    }
    
    public Optional<SkillModel> getById(Long id){
        return skRepository.findById(id);
    }
    
    public SkillModel updateById(SkillModel request, Long id){
        SkillModel skill = skRepository.findById(id).get();
        
        skill.setSk(request.getSk());
        skill.setPorcentaje(request.getPorcentaje());
        
        return skill;
    }
    
    public Boolean deleteExp (Long id){
        try{
            skRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
}
