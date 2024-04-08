package org.group.portfolio.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.group.portfolio.Entities.Education;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EducationDto {
    private String id;
    private String institution;
    private String degree;
    private int startYear;
    private int endYear;
    private String fieldOfStudy;
    private String location;
    private String description;

}
