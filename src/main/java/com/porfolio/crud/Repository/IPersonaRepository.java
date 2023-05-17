
package com.porfolio.crud.Repository;

import com.porfolio.crud.Model.PersonaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepository extends JpaRepository<PersonaModel, Long>{
    
}
