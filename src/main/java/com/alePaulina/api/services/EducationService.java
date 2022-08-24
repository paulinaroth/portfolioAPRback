
package com.alePaulina.api.services;

import com.alePaulina.api.models.Education;
import com.alePaulina.api.models.Person;
import com.alePaulina.api.repositories.EducationRepository;
import com.alePaulina.api.repositories.PersonRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Pauline
 */
@Service
public class EducationService implements IEducationService {
    
    @Autowired
    public EducationRepository eduRepo;
    @Autowired
    public PersonRepository persRepo;

    @Override
    public List<Education> seeEducations() {
        return eduRepo.findAll();
    }

    @Override
    public void createEducation(Long id, Education education) {
        Optional <Person> persOpt = this.persRepo.findById(id);
        if(persOpt.isPresent()){
            Person person = persOpt.get();
            education.setPers(person);
            Education nEducation = eduRepo.save(education);
        }
        this.eduRepo.save(education);
    }
    

    @Override
    public Optional<Education> findById(Long id) {
        return eduRepo.findById(id);
    }

    @Override
    public void deleteEducation(Long id) {
        eduRepo.deleteById(id);
    }

    @Override
    public void editEducation(Long id, Education education) {
        Optional <Education> edu = this.eduRepo.findById(id);
        if(edu.isPresent()){
            this.eduRepo.save(education);
        }
    }

    @Override
    public List<Education> findAllByPerson(Long personId) {
        List<Education> educationsRta = new ArrayList<>();
        List<Education> educations = eduRepo.findAll();
        for(int i=0; i<educations.size(); i++){
            if(educations.get(i).getPers().getId()==personId){
                educationsRta.add(educations.get(i));
            }
        }
        return educationsRta;
    }
    
}
