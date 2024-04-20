package org.group.portfolio.Service.Interfaces;

import org.group.portfolio.Dto.ProjectDto;
import org.group.portfolio.Entities.Project;

public interface ProjectService {
    public Project GetById(String id);
    public Project Create(ProjectDto projectDto);
    public Project Update(String id, ProjectDto projectDto);
    public String Delete(String id);
}
