
package com.porfolio.crud.Repository;

import com.porfolio.crud.Model.ExpModel;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExpRepository extends JpaRepository<ExpModel, Long>{
    

    
}
