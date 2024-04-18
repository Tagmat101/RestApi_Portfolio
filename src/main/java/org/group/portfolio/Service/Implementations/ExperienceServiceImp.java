package org.group.portfolio.Service.Implementations;

import org.group.portfolio.Dto.ExperienceDto;
import org.group.portfolio.Entities.Experience;
import org.group.portfolio.Exceptions.AppException;
import org.group.portfolio.Response.ErrorMessages;
import org.group.portfolio.Respository.ExperienceRepository;
import org.group.portfolio.Service.Interfaces.ExperienceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ExperienceServiceImp implements ExperienceService {
    @Autowired
    private ExperienceRepository experienceRepository;
    ModelMapper modelMapper = new ModelMapper();


    @Override
    public Experience Create(ExperienceDto educationDto) {
        if (educationDto == null) {
            throw new IllegalArgumentException("ExperienceDto must not be null");
        }
        Experience education = modelMapper.map(educationDto, Experience.class);
        if (education == null) {
            throw new AppException("Mapping from ExperienceDto to Experience failed");
        }

        return experienceRepository.save(education);
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
            experienceRepository.deleteById(id);
            return id;
        } else {
            throw new AppException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
        }
    }
}
