package org.group.portfolio.Service.Interfaces;

import org.group.portfolio.Dto.EducationDto;
import org.group.portfolio.Entities.Education;

import java.util.List;

public interface EducationService {
    public Education GetById(String id);
    public Education Create(EducationDto educationDto,String id);
    public Education Update(String id,EducationDto educationDto);
    public String Delete(String id);
    public List<Education> GetAllByUser(String id);
}
