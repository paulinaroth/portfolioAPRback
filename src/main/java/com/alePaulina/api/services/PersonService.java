
package com.alePaulina.api.services;

import com.alePaulina.api.models.Person;
import com.alePaulina.api.repositories.LocationRepository;
import com.alePaulina.api.repositories.PersonRepository;
import com.alePaulina.api.repositories.ProvinceRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Pauline
 */
@Service
public class PersonService implements IPersonService {
    
    @Autowired
    public PersonRepository persRepo;
    @Autowired
    public ProvinceRepository provRepo;
    @Autowired
    public LocationRepository locatRepo;

    @Override
    public List<Person> getAllPersons() {
        return  persRepo.findAll();
    }

    @Override
    public void createPerson(Person pers) {
        persRepo.save(pers);   
    }

    @Override
    public void deletePerson(Long id) {
        persRepo.deleteById(id);
    }

    @Override
    public Optional<Person> findById(Long pers_id) {
        return persRepo.findById(pers_id);
    }

    @Override
    public void editPerson(Long id, Person per) {
        Optional<Person> pers = this.persRepo.findById(id);
        if(pers.isPresent()){
            this.persRepo.save(per);
        }
        
    }

    @Override
    public List<Person> searchPersonByName(String name) {
        return persRepo.findByNameContaining(name);
    }

}
