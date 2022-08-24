
package com.alePaulina.api.repositories;

import com.alePaulina.api.models.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Pauline
 */
@Repository
public interface ProvinceRepository extends JpaRepository <Province, Long>{

    public Province findByNameContaining(String name);
}
