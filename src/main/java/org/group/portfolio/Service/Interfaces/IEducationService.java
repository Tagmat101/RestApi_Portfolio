package org.group.portfolio.Service.Interfaces;

import org.group.portfolio.Dto.EducationDto;
import org.group.portfolio.Dto.UserDto;
import org.group.portfolio.Entities.Education;
import org.group.portfolio.Entities.User;

public interface IEducationService {
    public Education GetById(String id);
    public Education Create(EducationDto educationDto);
    public Education Update(String id,EducationDto educationDto);
    public String Delete(String id);
}
