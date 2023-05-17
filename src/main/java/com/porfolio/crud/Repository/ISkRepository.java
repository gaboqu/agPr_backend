
package com.porfolio.crud.Repository;

import com.porfolio.crud.Model.SkillModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISkRepository extends JpaRepository<SkillModel, Long>{
    
}
