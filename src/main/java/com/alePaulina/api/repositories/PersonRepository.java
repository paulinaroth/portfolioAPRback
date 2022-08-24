
package com.alePaulina.api.repositories;

import com.alePaulina.api.models.Person;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Pauline
 */
@Repository
public interface PersonRepository extends JpaRepository <Person, Long>{
    public List<Person> findByNameContaining(String name);
}
