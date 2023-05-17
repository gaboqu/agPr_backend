
package com.porfolio.crud.Security.Service;

import com.porfolio.crud.Security.Entity.Rol;
import com.porfolio.crud.Security.Enums.RolNombre;
import com.porfolio.crud.Security.Repository.iRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
@Transactional
public class RolService {
    
    @Autowired
    iRolRepository iroRolRepository;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return iroRolRepository.findByRolNombre(rolNombre);
    }
    
    public void save(Rol rol){
        iroRolRepository.save(rol);
    }
    
}
