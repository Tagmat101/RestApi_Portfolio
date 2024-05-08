package org.group.portfolio.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.group.portfolio.Entities.Education;
import org.group.portfolio.Entities.Skill;
import org.group.portfolio.Entities.User;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExperienceDto {
    private String companyName;
    private String jobTitle;
    private String employmentType;
    private Date startDate;
    private Date endDate;
    private String description;
    private String[] responsibilities;
    private String[] achievements;
    private List<Skill> skills;
    private String companyLogo;
    private String location;
    User user;
}

