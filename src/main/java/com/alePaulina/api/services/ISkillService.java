
package com.alePaulina.api.services;

import com.alePaulina.api.models.Skill;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Pauline
 */
public interface ISkillService {
    
    
    public List<Skill> seeSkills();
    public void create(Long id, Skill skill);
    public Optional<Skill> findById(Long id);
    public void deleteSkill(Long id);
    public void editSkill(Long id, Skill skill);
    public List<Skill> findAllByPerson(Long personId);
    

    
}
