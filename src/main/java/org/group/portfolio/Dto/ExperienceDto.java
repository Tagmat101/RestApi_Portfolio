package org.group.portfolio.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.group.portfolio.Entities.Education;
import org.group.portfolio.Entities.Skill;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExperienceDto {
    private String companyName;
    private String jobTitle;
    private Date startDate;
    private Date endDate;
    private String description;
    private String[] responsibilities;
    private String[] achievements;
    private Skill[] skills;
}

