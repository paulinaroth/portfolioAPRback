
package com.alePaulina.api.services;

import com.alePaulina.api.models.Project;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Pauline
 */
public interface IProjectService {
    public List<Project> seeProjects();
    public void createProject(Long persId, Project project);
    public Optional<Project> findById(Long id);
    public void deleteProject(Long id);
    public void editProject(Long id, Project project);
    public List<Project> findAllByPerson(Long personId);
}
