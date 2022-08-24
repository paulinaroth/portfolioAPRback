
package com.alePaulina.api.services;

import com.alePaulina.api.models.Person;
import com.alePaulina.api.models.Skill;
import com.alePaulina.api.repositories.PersonRepository;
import com.alePaulina.api.repositories.SkillRepository;
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
public class SkillService implements ISkillService{
    
    @Autowired
    public SkillRepository skillRepo;
    @Autowired
    public PersonRepository persRepo;

    

    @Override
    public List<Skill> seeSkills() {
        return skillRepo.findAll();
    }

    @Override
    public void create(Long id, Skill skill){
        Optional <Person> persOpt = this.persRepo.findById(id);
        if(persOpt.isPresent()){
            Person person = persOpt.get();
            skill.setPers(person);
            Skill nSkill = skillRepo.save(skill);
        }
    }

    @Override
    public Optional<Skill> findById(Long id) {
        return skillRepo.findById(id);
    }

    @Override
    public void deleteSkill(Long id) {
        skillRepo.deleteById(id);
    }

    @Override
    public void editSkill(Long id, Skill skill) {
        
        Optional <Skill> sk = this.skillRepo.findById(id);
        if(sk.isPresent()){
            this.skillRepo.save(skill); 
        }
    }

    @Override
    public List<Skill> findAllByPerson(Long personId) {
        List<Skill> skillsRta = new ArrayList<>();
        List<Skill> skills = skillRepo.findAll();
        for(int i=0; i<skills.size(); i++){
            if(skills.get(i).getPers().getId()==personId){
                skillsRta.add(skills.get(i));
            }
        }
        return skillsRta;
    }
}
