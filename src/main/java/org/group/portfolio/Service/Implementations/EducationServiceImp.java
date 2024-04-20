package org.group.portfolio.Service.Implementations;
import org.group.portfolio.Dto.EducationDto;
import org.group.portfolio.Entities.Education;
import org.group.portfolio.Exceptions.AppException;
import org.group.portfolio.Response.ErrorMessages;
import org.group.portfolio.Respository.EducationRepository;
import org.group.portfolio.Service.Interfaces.IEducationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationServiceImp implements IEducationService {
    @Autowired
    private EducationRepository educationRepository;
    ModelMapper modelMapper = new ModelMapper();


    @Override
    public Education Create(EducationDto educationDto) {
        if (educationDto == null) {
            throw new IllegalArgumentException("EducationDto must not be null");
        }
        Education education = modelMapper.map(educationDto, Education.class);
        if (education == null) {
            throw new AppException("Mapping from EducationDto to Education failed");
        }

        return educationRepository.save(education);
    }

    public Education GetById(String id) {
        // Retrieve Education from the database
        return educationRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage()));
    }
    public List<Education> GetAll() {
        return educationRepository.findAll();
    }

    @Override
    public Education Update(String id, EducationDto educationDto) {
        Education education = educationRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage()));

        // Update education object with fields from educationDto
        modelMapper.map(educationDto, education);

        return educationRepository.save(education);
    }


    @Override
    public String Delete(String id) {
        if (educationRepository.existsById(id)) {
            educationRepository.deleteById(id);
            return id;
        } else {
            throw new AppException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
        }
    }
    //    @Override
//    public Education Delete(String id) {
//        Assert.notNull(id, "Education ID must not be null");
//        if (educationRepository.existsById(id)) {
//            educationRepository.deleteById(id);
//            return "deleted";
//        } else {
//            return "Education not found";
//        }
//    }
}
