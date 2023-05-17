
package com.porfolio.crud.Repository;

import com.porfolio.crud.Model.ProyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface IProyRepository extends JpaRepository<ProyModel, Long>{
    
}
