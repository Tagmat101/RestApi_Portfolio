package org.group.portfolio.Service.Implementations;

import org.group.portfolio.Dto.ProjectDto;
import org.group.portfolio.Entities.Education;
import org.group.portfolio.Entities.Portfolio;
import org.group.portfolio.Entities.Project;
import org.group.portfolio.Entities.User;
import org.group.portfolio.Exceptions.AppException;
import org.group.portfolio.Response.ErrorMessages;
import org.group.portfolio.Respository.PortfolioRepository;
import org.group.portfolio.Respository.ProjectRepository;
import org.group.portfolio.Respository.UserRepository;
import org.group.portfolio.Service.Interfaces.ProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@Service
public class ProjectServiceImp implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private UserRepository userRepository;
    ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private PortfolioRepository portfolioRepository;

    @Override
    public Project Create(ProjectDto projectDto, String id) {
        if (projectDto == null) {
            throw new IllegalArgumentException("ProjectDto must not be null");
        }
        System.out.println(projectDto);

        Project project = modelMapper.map(projectDto, Project.class);

        User user = userRepository.findById(id).orElseThrow(() ->
                new AppException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage()));
        project.setUser(user);
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
        if (projectDto.getResponsibilities() != null) {
            project.setResponsibilities(projectDto.getResponsibilities());
        }
        if (projectDto.getAchievements() != null) {
            project.setAchievements(projectDto.getAchievements());
        }
        if (projectDto.getSkills() != null) {
            project.setSkills(projectDto.getSkills());
        }
        return projectRepository.save(project);
    }


    @Override
    public String Delete(String id) {
        if (projectRepository.existsById(id)) {

            List<Portfolio> portfolios = portfolioRepository.findAll();
            for(Portfolio portfolio : portfolios)
            {
                List<Project> projects = portfolio.getProjects();
                projects.removeIf(project -> project.getId().equals(id));
                portfolio.setProjects(projects);
                portfolioRepository.save(portfolio);
            }
            projectRepository.deleteById(id);
            return id;
        } else {
            throw new AppException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
        }
    }
    @Override
    public List<Project> GetAllByUser(String id) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new AppException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage()));

        return projectRepository.findAllByUser(user);
    }
    @Override
    public long GetCountProjectsAll(String id) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new AppException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage()));

        return projectRepository.countByUser(user);
    }

}
