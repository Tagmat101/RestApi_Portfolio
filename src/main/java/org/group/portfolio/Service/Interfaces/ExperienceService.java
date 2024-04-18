package org.group.portfolio.Service.Interfaces;

import org.group.portfolio.Dto.ExperienceDto;
import org.group.portfolio.Entities.Experience;

public interface ExperienceService {
    public Experience GetById(String id);
    public Experience Create(ExperienceDto experienceDto);
    public Experience Update(String id, ExperienceDto experienceDto);
    public String Delete(String id);
}