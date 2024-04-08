package org.group.portfolio.Service.Implementations;

import org.group.portfolio.Dto.ProjectDto;
import org.group.portfolio.Dto.ProjectDto;
import org.group.portfolio.Entities.Project;
import org.group.portfolio.Exceptions.AppException;
import org.group.portfolio.Response.ErrorMessages;
import org.group.portfolio.Respository.ProjectRepository;
import org.group.portfolio.Service.Interfaces.IProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProjectServiceImp implements IProjectService {
    @Autowired
    private ProjectRepository projectRepository;
    ModelMapper modelMapper = new ModelMapper();


    @Override
    public Project Create(ProjectDto projectDto) {
        if (projectDto == null) {
            throw new IllegalArgumentException("ProjectDto must not be null");
        }
        Project project = modelMapper.map(projectDto, Project.class);
        if (project == null) {
            throw new AppException("Mapping from ProjectDto to Project failed");
        }

        return projectRepository.save(project);
    }

    public Project GetById(String id) {
        // Retrieve Project from the database
        return projectRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage()));
    }
    public List<Project> GetAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project Update(String id, ProjectDto projectDto) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage()));

        // Update project object with fields from projectDto
        modelMapper.map(projectDto, project);

        return projectRepository.save(project);
    }


    @Override
    public String Delete(String id) {
        if (projectRepository.existsById(id)) {
            projectRepository.deleteById(id);
            return id;
        } else {
            throw new AppException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
        }
    }
}