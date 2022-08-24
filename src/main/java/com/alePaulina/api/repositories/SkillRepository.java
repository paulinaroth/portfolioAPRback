
package com.alePaulina.api.repositories;

import com.alePaulina.api.models.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Pauline
 */
@Repository
public interface SkillRepository extends JpaRepository <Skill, Long>{
    
}
