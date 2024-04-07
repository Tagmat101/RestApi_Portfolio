package org.group.portfolio.Dto;

import lombok.Data;
import org.group.portfolio.Entities.Education;

@Data
public class EducationDto {
    private String id;
    private String institution;
    private String degree;
    private int startYear;
    private int endYear;
    private String fieldOfStudy;
    private String location;
    private String description;

    public EducationDto(String id, String institution, String degree, int startYear, int endYear, String fieldOfStudy, String location, String description) {
        this.id = id;
        this.institution = institution;
        this.degree = degree;
        this.startYear = startYear;
        this.endYear = endYear;
        this.fieldOfStudy = fieldOfStudy;
        this.location = location;
        this.description = description;
    }

    public EducationDto(Education education) {
        this.id = education.getId();
        this.institution = education.getInstitution();;
        this.degree = education.getDegree();;
        this.startYear = education.getStartYear();;
        this.endYear = education.getEndYear();;
        this.fieldOfStudy = education.getFieldOfStudy();;
        this.location = education.getLocation();;
        this.description = education.getDescription();;
    }

    @Override
    public String toString() {
        return "EducationDto{" +
                "id='" + id + '\'' +
                ", institution='" + institution + '\'' +
                ", degree='" + degree + '\'' +
                ", startYear=" + startYear +
                ", endYear=" + endYear +
                ", fieldOfStudy='" + fieldOfStudy + '\'' +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
