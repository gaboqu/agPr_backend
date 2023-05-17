
package com.porfolio.crud.Servicios;

import com.porfolio.crud.Model.ExpModel;
import com.porfolio.crud.Repository.IExpRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpService {
    
    @Autowired
    IExpRepository expRepository;
    
    public ArrayList<ExpModel> getExp(){
        return (ArrayList<ExpModel>) expRepository.findAll();
    }
    
    public ExpModel saveExp(ExpModel exp){
        return  expRepository.save(exp);
    }
    
    public Optional<ExpModel> getById(Long id){
        return expRepository.findById(id);
    }
    
    public ExpModel updateById(ExpModel request, Long id){
        ExpModel exp = expRepository.findById(id).get();
        
        exp.setEmpresa(request.getEmpresa());
        exp.setUrl_logo_exp(request.getUrl_logo_exp());
        exp.setFechas_ing_egr(request.getFechas_ing_egr());
        exp.setFunciones(request.getFunciones());
        
        return exp;
    }
    
    public Boolean deleteExp (Long id){
        try{
            expRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }
            
    
}
