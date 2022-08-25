
package com.alePaulina.api.controllers;

import com.alePaulina.api.exception.NotFoundException;
import com.alePaulina.api.models.Person;
import com.alePaulina.api.models.Project;
import com.alePaulina.api.services.IPersonService;
import com.alePaulina.api.services.IProjectService;
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
@CrossOrigin(origins = "https://portfolio-ap-35745.web.app")
@RestController
public class ProjectController {
    
    @Autowired
    private IProjectService projectServ;
    @Autowired
    private IPersonService perServ;
    
    @GetMapping("projects")
    public ResponseEntity<List<Project>> seeProjects(){
        return new ResponseEntity<> (projectServ.seeProjects(), HttpStatus.OK);
    } 
    
    @PostMapping("/person/{persId}/project/add")
    public ResponseEntity createProject(@PathVariable Long persId, @RequestBody Project project) throws Exception{
        Optional<Person> persOpt = perServ.findById(persId);
        if(persOpt.isEmpty()){
            throw new NotFoundException("La persona a la que desea agregar un proyecto no existe en la base de datos");
        }
        projectServ.createProject(persId, project);
        return new ResponseEntity<>(project, HttpStatus.CREATED);
    }
    
    @GetMapping("/project/search/{id}")
    public ResponseEntity<Optional<Project>> findById(@PathVariable Long id){
        Optional <Project> project = projectServ.findById(id);
        if (project.isEmpty()){
            throw new NotFoundException("El proyecto que busca no se encuentra en la base de datos.");
        }
        return new ResponseEntity<> (project, HttpStatus.OK);
    }
    
    @DeleteMapping("/project/delete/{id}")
    public ResponseEntity<Object> deleteProject(@PathVariable Long id) throws Exception{
        Optional<Project> project = projectServ.findById(id);
        if(project.isEmpty()){
            throw new NotFoundException("El proyecto que desea eliminar no existe en la base de datos");
        }
        projectServ.deleteProject(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PutMapping("project/edit/{id}")
    public ResponseEntity editProject(@PathVariable Long id, @RequestBody Project project) {
        Optional<Project> OptProject = projectServ.findById(id);
        if(OptProject.isEmpty()){
            throw new NotFoundException("El proyecto que desea editar no existe en la base de datos");
        }
        this.projectServ.editProject(id, project);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }
    
    @GetMapping("/projects/byPerson/{personId}") 
    public ResponseEntity<List<Project>> findAllByPerson(@PathVariable Long personId) {
        return new ResponseEntity(projectServ.findAllByPerson(personId), HttpStatus.OK);
    }
            
}
