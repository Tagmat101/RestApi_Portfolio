package org.group.portfolio.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.group.portfolio.Entities.*;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PortfolioDto {
    User user;
    List<ExperienceDto> experiences;
    List<ProjectDto> projects;
    List<SkillDto> skills;
    List<EducationDto> educations;
}
