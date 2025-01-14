package org.group.portfolio.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.group.portfolio.Entities.Skill;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {
    private String link;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private List<Skill> skills;

    private String[] responsibilities;
    private String[] achievements;
    private List<String> media;
    private String imageUrl;

}
