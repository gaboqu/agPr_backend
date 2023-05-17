
package com.porfolio.crud.Repository;

import com.porfolio.crud.Model.EduModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEduRepository  extends  JpaRepository<EduModel, Long>{
    
}
