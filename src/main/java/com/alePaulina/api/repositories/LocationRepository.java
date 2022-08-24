
package com.alePaulina.api.repositories;

import com.alePaulina.api.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Pauline
 */
@Repository
public interface LocationRepository extends JpaRepository<Location, Long>{
    
}
