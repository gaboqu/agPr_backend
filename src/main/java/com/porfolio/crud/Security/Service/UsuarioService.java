
package com.porfolio.crud.Security.Service;

import com.porfolio.crud.Security.Entity.Usuario;
import com.porfolio.crud.Security.Repository.iUsuarioRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
@Transactional
public class UsuarioService {
    
    @Autowired
    iUsuarioRepository iusarioRepository; 
    
    
    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
        return iusarioRepository.findByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByNombreUsuario(String nombreUsuario){
        return iusarioRepository.existsByNombreUsuario( nombreUsuario);
    }
    
    public boolean existsByEmail(String email){
        return iusarioRepository.existsByEmail( email);
    }
    
    public void save(Usuario usuario){
        iusarioRepository.save(usuario);
    }
    
}
