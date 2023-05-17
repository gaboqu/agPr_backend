
package com.porfolio.crud.Servicios;

import com.porfolio.crud.Model.EduModel;
import com.porfolio.crud.Repository.IEduRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EduService {
    
    @Autowired
    IEduRepository eduRepository;
    
     public ArrayList<EduModel> getEdu(){
        return (ArrayList<EduModel>) eduRepository.findAll();
    }
    
    public EduModel saveEdu(EduModel edu){
        return  eduRepository.save(edu);
    }
    
    public Optional<EduModel> getById(Long id){
        return eduRepository.findById(id);
    }
    
    public EduModel updateById(EduModel request, Long id){
        EduModel edu = eduRepository.findById(id).get();
        
        edu.setImg(request.getImg());
        edu.setTitulo(request.getTitulo());
        edu.setInstitucion(request.getInstitucion());
        edu.setInfo(request.getInfo());
        
        return edu;
    }
    
    public Boolean deleteEdu (Long id){
        try{
            eduRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
}
