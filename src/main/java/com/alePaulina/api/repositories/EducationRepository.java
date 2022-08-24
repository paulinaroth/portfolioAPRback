
package com.alePaulina.api.repositories;

import com.alePaulina.api.models.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Pauline
 */
@Repository
public interface EducationRepository extends JpaRepository <Education, Long>{
    
}
