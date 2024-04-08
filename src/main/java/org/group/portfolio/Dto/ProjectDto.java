package org.group.portfolio.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {
    private String id;
    private String link;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private String[] technologiesUsed;
    private String[] responsibilities;
    private String[] achievements;
}
