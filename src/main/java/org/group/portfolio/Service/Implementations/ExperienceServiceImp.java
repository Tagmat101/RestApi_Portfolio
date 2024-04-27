package org.group.portfolio.Service.Implementations;

import org.group.portfolio.Dto.ExperienceDto;
import org.group.portfolio.Entities.Education;
import org.group.portfolio.Entities.Experience;
import org.group.portfolio.Entities.Portfolio;
import org.group.portfolio.Entities.User;
import org.group.portfolio.Exceptions.AppException;
import org.group.portfolio.Response.ErrorMessages;
import org.group.portfolio.Respository.ExperienceRepository;
import org.group.portfolio.Respository.PortfolioRepository;
import org.group.portfolio.Respository.UserRepository;
import org.group.portfolio.Service.Interfaces.ExperienceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ExperienceServiceImp implements ExperienceService {
    @Autowired
    private ExperienceRepository experienceRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PortfolioRepository portfolioRepository;
    ModelMapper modelMapper = new ModelMapper();


    @Override
    public Experience Create(ExperienceDto educationDto,String id) {
        if (educationDto == null) {
            throw new IllegalArgumentException("ExperienceDto must not be null");
        }
        Experience experience = modelMapper.map(educationDto, Experience.class);
        User user = userRepository.findById(id).orElseThrow(() ->
                new AppException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage()));
        experience.setUser(user);
        if (experience == null) {
            throw new AppException("Mapping from ExperienceDto to Experience failed");
        }

        return experienceRepository.save(experience);
    }

    public Experience GetById(String id) {
        // Retrieve Experience from the database
        return experienceRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage()));
    }
    public List<Experience> GetAll() {
        return experienceRepository.findAll();
    }

    @Override
    public Experience Update(String id, ExperienceDto educationDto) {
        Experience education = experienceRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage()));

        // Update education object with fields from educationDto
        modelMapper.map(educationDto, education);
        if (educationDto.getResponsibilities() != null) {
            education.setResponsibilities(educationDto.getResponsibilities());
        }
        if (educationDto.getAchievements() != null) {
            education.setAchievements(educationDto.getAchievements());
        }
        if (educationDto.getSkills() != null) {
            education.setSkills(educationDto.getSkills());
        }
        return experienceRepository.save(education);
    }


    @Override
    public String Delete(String id) {
        if (experienceRepository.existsById(id)) {

            List<Portfolio> portfolios = portfolioRepository.findAll();
            for(Portfolio portfolio : portfolios)
            {
                List<Experience> experiences = portfolio.getExperiences();
                experiences.removeIf(experience -> experience.getId().equals(id));
                portfolio.setExperiences(experiences);
                portfolioRepository.save(portfolio);
            }
            experienceRepository.deleteById(id);
            return id;
        } else {
            throw new AppException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
        }
    }
    @Override
    public List<Experience> GetAllByUser(String id) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new AppException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage()));

        return experienceRepository.findAllByUser(user);
    }
}
