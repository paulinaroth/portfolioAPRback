
package com.alePaulina.api.controllers;

import com.alePaulina.api.exception.NotFoundException;
import com.alePaulina.api.models.Person;
import com.alePaulina.api.models.Skill;
import com.alePaulina.api.repositories.PersonRepository;
import com.alePaulina.api.services.ISkillService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Pauline
 */
@CrossOrigin(origins = "*")
@RestController
public class SkillController {
    
    @Autowired
    private ISkillService skServ;
    @Autowired
    private PersonRepository persRepo;
    
    @GetMapping("/skills")
    public ResponseEntity<List<Skill>> getAllSkills(){
        return new ResponseEntity<> (skServ.seeSkills(), HttpStatus.OK);
    }
    
    @PostMapping("/person/{persId}/skill/add")
    public ResponseEntity<Skill> addSkill (@PathVariable ("persId") Long persId, @RequestBody Skill skill) throws Exception{
        Optional<Person> persOpt = persRepo.findById(persId);
        if(persOpt.isEmpty()){
            throw new NotFoundException("La persona a la que desea agregar una habilidad no existe en la base de datos");
        }
        skServ.create(persId, skill);
        return new ResponseEntity<>(skill, HttpStatus.CREATED);
    }
    
       
    @GetMapping("/skill/search/{id}")
    public ResponseEntity<Optional<Skill>> searchSkill(@PathVariable Long id)throws Exception{
        Optional <Skill> skill = skServ.findById(id);
        if (skill.isEmpty()){
            throw new NotFoundException("La habilidad que busca no se encuentra en la base de datos.");
        }
        return new ResponseEntity<> (skill, HttpStatus.OK);
    }
    
    
    @DeleteMapping("/skill/delete/{id}")
    public ResponseEntity<Object> deleteSkill (@PathVariable Long id)throws Exception{
        Optional<Skill> skill = skServ.findById(id);
        if(skill.isEmpty()){
            throw new NotFoundException("La habilidad que desea eliminar no se encuentra en la base de datos");
        }
        skServ.deleteSkill(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PutMapping("skill/edit/{id}")
    public ResponseEntity<Skill> editSkill(@PathVariable Long id, @RequestBody Skill skill)throws Exception{
        Optional<Skill> OptSkill = skServ.findById(id);
        if(OptSkill.isEmpty()){
            throw new NotFoundException("La habilidad que desea editar no se encuentra en la base de datos");
        }
        this.skServ.editSkill(id, skill);
        return new ResponseEntity<>(skill, HttpStatus.OK);
    }
    
     @GetMapping("/skill/byPerson/{personId}") 
    public ResponseEntity<List<Skill>> findAllByPerson(@PathVariable Long personId) {
        return new ResponseEntity(skServ.findAllByPerson(personId), HttpStatus.OK);
    }
}
