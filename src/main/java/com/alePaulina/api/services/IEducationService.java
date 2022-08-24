
package com.alePaulina.api.services;

import com.alePaulina.api.models.Education;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Pauline
 */
public interface IEducationService {
    public List<Education> seeEducations();
    public void createEducation(Long id, Education education);
    public Optional<Education> findById(Long id);
    public void deleteEducation(Long id);
    public void editEducation(Long id, Education education);
    public List<Education> findAllByPerson(Long personId);
}
