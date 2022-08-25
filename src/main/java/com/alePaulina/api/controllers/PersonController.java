
package com.alePaulina.api.controllers;

import com.alePaulina.api.exception.NotFoundException;
import com.alePaulina.api.models.Person;
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


// @author Pauline



@RestController
public class PersonController {
    
    @Autowired
    private IPersonService perServ;
    
    @PostMapping("/person/new")   
    public ResponseEntity<Person> createPerson (@RequestBody Person per){
        perServ.createPerson(per);
        return new ResponseEntity<>(per, HttpStatus.CREATED);
    }
    
    @GetMapping("/persons")   
    public ResponseEntity<List<Person>> getAllPersons(){
        return new ResponseEntity<>(perServ.getAllPersons(), HttpStatus.OK);
    }
    
    @DeleteMapping("/person/delete/{id}")
    public ResponseEntity<Object> deletePerson(@PathVariable Long id) throws Exception{
        Optional<Person> person = perServ.findById(id);
        if(person.isEmpty()){
            throw new NotFoundException("El usuario que desea eliminar no existe en la base de datos");
        }
        perServ.deletePerson(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PutMapping("/person/edit/{id}")
    public ResponseEntity<Person> editPerson(@PathVariable Long id,@RequestBody Person per){
        this.perServ.editPerson(id, per);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
    @GetMapping("person/search/{id}")
    public ResponseEntity<Optional<Person>> searchPerson(@PathVariable Long id)throws Exception{
        Optional<Person> person = perServ.findById(id);
        if(person.isEmpty()){
            throw new NotFoundException("El usuario que busca no se encuentra en la base de datos.");
        }
        return new ResponseEntity<>(person, HttpStatus.OK);
    }
    
    @GetMapping("persons/byName/{name}")   
    public List<Person> PersonsByName(@PathVariable String name){
        return perServ.searchPersonByName(name);
    }
}


