package org.group.portfolio.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.group.portfolio.Entities.Education;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EducationDto {
    private String institution;
    private String degree;
    private Date startDate;
    private Date endDate;
    private String fieldOfStudy;
    private String location;
    private String description;

}
