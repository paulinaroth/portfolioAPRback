
package com.alePaulina.api.services;

import com.alePaulina.api.models.Person;
import com.alePaulina.api.models.Project;
import com.alePaulina.api.repositories.PersonRepository;
import com.alePaulina.api.repositories.ProjectRepository;
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
public class ProjectService implements IProjectService{
    
    @Autowired
    public ProjectRepository projectRepo;
    @Autowired
    public PersonRepository persRepo;
    

    @Override
    public List<Project> seeProjects() {
        return projectRepo.findAll();
    }

    @Override
    public void createProject(Long persId, Project project) {
        Optional <Person> persOpt = this.persRepo.findById(persId);
        if(persOpt.isPresent()){
            Person person = persOpt.get();
            project.setPers(person);
            Project nProject = projectRepo.save(project);
        }
        this.projectRepo.save(project);
    }

    @Override
    public Optional<Project> findById(Long id) {
        return projectRepo.findById(id);
    }

    @Override
    public void deleteProject(Long id) {
        projectRepo.deleteById(id);
    }

    @Override
    public void editProject(Long id, Project project) {
        Optional <Project> pct = this.projectRepo.findById(id);
        if(pct.isPresent()){
            this.projectRepo.save(project);
        }
    }

    @Override
    public List<Project> findAllByPerson(Long personId) {
       List<Project> projectsRta = new ArrayList<>();
        List<Project> projects = projectRepo.findAll();
        for(int i=0; i<projects.size(); i++){
            if(projects.get(i).getPers().getId()==personId){
                projectsRta.add(projects.get(i));
            }
        }
        return projectsRta;
    }
    
}
