
package com.alePaulina.api.repositories;

import com.alePaulina.api.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Pauline
 */
@Repository
public interface ProjectRepository extends JpaRepository <Project, Long> {
    
}
