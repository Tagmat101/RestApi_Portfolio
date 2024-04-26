package org.group.portfolio.Service.Interfaces;

import org.group.portfolio.Dto.ProjectDto;
import org.group.portfolio.Entities.Education;
import org.group.portfolio.Entities.Project;

import java.util.List;

public interface ProjectService {
    public Project GetById(String id);
    public Project Create(ProjectDto projectDto,String id);
    public Project Update(String id, ProjectDto projectDto);
    public String Delete(String id);
    public List<Project> GetAllByUser(String id);
}
