package org.group.portfolio.Service.Implementations;

import org.apache.catalina.util.ErrorPageSupport;
import org.group.portfolio.Dto.ProjectDto;
import org.group.portfolio.Dto.SkillDto;
import org.group.portfolio.Entities.*;
import org.group.portfolio.Exceptions.AppException;
import org.group.portfolio.Response.ErrorMessages;
import org.group.portfolio.Respository.*;
import org.group.portfolio.Service.Interfaces.SkillService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SkillServiceImp implements SkillService {

    @Autowired
    private SkillRepository skillRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PortfolioRepository portfolioRepository;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private ExperienceRepository experienceRepository;
    ModelMapper modelMapper = new ModelMapper();

    @Override
    public Skill Create(SkillDto skillDto, String id) {
        if (skillDto == null) {
            throw new IllegalArgumentException("SkillDto must not be null");
        }
        Skill skill = modelMapper.map(skillDto, Skill.class);
        User user = userRepository.findById(id).orElseThrow(() ->
                new AppException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage()));
        skill.setUser(user);
        if (skill == null) {
            throw new AppException("Mapping from skillDto to Project failed");
        }

        return skillRepository.save(skill);
    }


    public Skill GetById(String id) {
        // Retrieve Project from the database
        return skillRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage()));
    }


    @Override
    public Skill Update(String idSkill, SkillDto SkillDto) {
        Skill skill = skillRepository.findById(idSkill)
                .orElseThrow(() -> new AppException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage()));
        // Update project object with fields from projectDto
        modelMapper.map(SkillDto, skill);
        return skillRepository.save(skill);
    }


    @Override
    public String Delete(String id) {
        if (skillRepository.existsById(id)) {

//            List<Portfolio> portfolios = portfolioRepository.findAll();
//            for(Portfolio portfolio : portfolios)
//            {
//                List<Skill> skills = portfolio.getSkills();
//                skills.removeIf(project -> project.getId().equals(id));
//                portfolio.setSkills(skills);
//                portfolioRepository.save(portfolio);
//            }

//            List<Project> projects = projectRepository.findAll();
//            projects.forEach(project -> project.getSkills().removeIf(skill -> skill.getId().equals(id)));
//            projectRepository.saveAll(projects);
//
//            List<Experience> experiences = experienceRepository.findAll();
//            experiences.forEach(experience -> experience.getSkills().removeIf(skill -> skill.getId().equals(id)));
//            experienceRepository.saveAll(experiences);


            skillRepository.deleteById(id);
            return id;
        } else {
            throw new AppException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
        }
    }
    @Override
    public List<Skill> GetAllByUser(String id) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new AppException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage()));

        return skillRepository.findAllByUser(user);
    }
}
