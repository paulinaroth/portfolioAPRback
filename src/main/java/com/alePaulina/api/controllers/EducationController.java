
package com.alePaulina.api.controllers;

import com.alePaulina.api.exception.NotFoundException;
import com.alePaulina.api.models.Education;
import com.alePaulina.api.models.Person;
import com.alePaulina.api.services.IEducationService;
import com.alePaulina.api.services.IPersonService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

@RestController
public class EducationController {
    
    @Autowired
    private IEducationService eduServ;
    @Autowired
    private IPersonService perServ;
    
    @GetMapping("/educations")
    public ResponseEntity<List<Education>> getAllSkills(){
        return new ResponseEntity<> (eduServ.seeEducations(), HttpStatus.OK);
    }
    
    @PostMapping("/person/{persId}/education/add")
    public ResponseEntity<Education> createEducation(@PathVariable Long persId, @RequestBody Education education) throws Exception{
        Optional<Person> person = perServ.findById(persId);
        if (person.isEmpty()){
            throw new NotFoundException("La persona a la que desea agregar una educación no existe en la base de datos");
        }
        eduServ.createEducation(persId, education);
        return new ResponseEntity<> (education, HttpStatus.CREATED);
    }
    
    @GetMapping("education/search/{id}")
    public ResponseEntity<Optional<Education>> findById(@PathVariable Long id) throws Exception{
        Optional<Education> education = eduServ.findById(id);
        if(education.isEmpty()){
            throw new NotFoundException("La educación que busca no se encuentra en la base de datos.");
        }
        return new ResponseEntity<> (education, HttpStatus.OK);
    }
    
    @DeleteMapping("/education/delete/{id}")
    public ResponseEntity<Object> deleteEducation(@PathVariable Long id) throws Exception{
        Optional<Education> education = eduServ.findById(id);
        if(education.isEmpty()){
            throw new NotFoundException ("La educación que desea eliminar no existe en la base de datos");
        }
        eduServ.deleteEducation(id);
        return new ResponseEntity<> (HttpStatus.OK);
    }
    
    
    @PutMapping("education/edit/{id}")
    public ResponseEntity<Education> editEducation(@PathVariable Long id, @RequestBody Education education)throws Exception{
        Optional<Education> optEduc = eduServ.findById(id);
        if(optEduc.isEmpty()){
            throw new NotFoundException("La educación que desea editar no existe en la base de datos");
        }
        this.eduServ.editEducation(id, education);
        return new ResponseEntity<>(education, HttpStatus.OK);
    }
    
    @GetMapping("/education/byPerson/{personId}") 
    public ResponseEntity<List<Education>> findAllByPerson(@PathVariable Long personId) {
        return new ResponseEntity(eduServ.findAllByPerson(personId), HttpStatus.OK);
    }
}
