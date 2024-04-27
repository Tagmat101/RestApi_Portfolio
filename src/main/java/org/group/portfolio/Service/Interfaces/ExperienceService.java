package org.group.portfolio.Service.Interfaces;

import org.group.portfolio.Dto.ExperienceDto;
import org.group.portfolio.Entities.Education;
import org.group.portfolio.Entities.Experience;

import java.util.List;

public interface ExperienceService {
    public Experience GetById(String id);
    public Experience Create(ExperienceDto experienceDto,String id);
    public Experience Update(String id, ExperienceDto experienceDto);
    public String Delete(String id);
    public List<Experience> GetAllByUser(String id);
}