
package com.alePaulina.api.services;

import com.alePaulina.api.models.Person;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Pauline
 */
public interface IPersonService {
    public List<Person> getAllPersons();
    public void createPerson (Person pers);
    public void deletePerson (Long id);
    public List<Person> searchPersonByName(String name);
    public void editPerson(Long id, Person per);
    public Optional<Person> findById(Long pers_id);
    
}
