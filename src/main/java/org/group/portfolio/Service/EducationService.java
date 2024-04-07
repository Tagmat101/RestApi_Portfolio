package org.group.portfolio.Service;
import org.group.portfolio.Dto.EducationDto;
import org.group.portfolio.Entities.Education;
import org.group.portfolio.Entities.User;
import org.group.portfolio.Respository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.util.Assert;
import java.util.ArrayList;
import java.util.List;
@Service
public class EducationService {
    @Autowired
    private EducationRepository educationRepository;
    public String createEducation(@RequestBody EducationDto educationDto) {
        try
        {
//            Education education = new Education(educationDto);
//            educationRepository.save(education);
            Education education = Education.builder()
                    .id(educationDto.getId())
                    .institution(educationDto.getInstitution())
                    .degree(educationDto.getDegree())
                    .description(educationDto.getDescription())
                    .endYear(educationDto.getEndYear())
                    .fieldOfStudy(educationDto.getFieldOfStudy())
                    .location(educationDto.getLocation())
                    .startYear(educationDto.getStartYear())
                    .build();
            educationRepository.save(education);
        } catch(Exception e)
        {
            return "Faulty : " + e.getMessage();
        }
        return "created";
    }

    public List<EducationDto> getAllEducation() {
        List<EducationDto> educations = new ArrayList<>();

        // Retrieve all education entries from the database
        List<Education> educationEntities = educationRepository.findAll();

        // Convert Education entities to EducationDto objects
        for (Education educationEntity : educationEntities) {
            EducationDto educationDto = new EducationDto(educationEntity);
            educations.add(educationDto);
        }

        return educations;
    }

    public EducationDto getEducationById(String id) {
        Assert.notNull(id, "Education ID must not be null");

        // Retrieve Education from the database
        Education education = educationRepository.findById(id).orElse(null);

        // Convert Education to EducationDto
        if (education != null) {
           return new EducationDto(education);
        }
        return null;
    }

    public String updateEducation(String id, EducationDto updatedEducationDto) {
        Assert.notNull(id, "Education ID must not be null");
        Education education = educationRepository.findById(id).orElse(null);
        if (education != null) {
            education.setInstitution(updatedEducationDto.getInstitution());
            education.setDegree(updatedEducationDto.getDegree());
            education.setDescription(updatedEducationDto.getDescription());
            education.setEndYear(updatedEducationDto.getEndYear());
            education.setFieldOfStudy(updatedEducationDto.getFieldOfStudy());
            education.setLocation(updatedEducationDto.getLocation());
            education.setStartYear(updatedEducationDto.getStartYear());
            educationRepository.save(education);
            return "updated";
        } else {
            return "Education not found";
        }
    }
    public String deleteEducation(String id) {
        Assert.notNull(id, "Education ID must not be null");
        if (educationRepository.existsById(id)) {
            educationRepository.deleteById(id);
            return "deleted";
        } else {
            return "Education not found";
        }
    }
}
