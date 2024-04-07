package org.group.portfolio.Entities;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.group.portfolio.Dto.EducationDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document(collection = "Education")
@Data
@Builder
public class Education {
    @Id
    private String id;
    private String institution;
    private String degree;
    private int startYear;
    private int endYear;
    private String fieldOfStudy;
    private String location;
    private String description;

//    public Education(EducationDto educationDto) {
//        this.id = educationDto.getId();
//        this.institution = educationDto.getId();;
//        this.degree = educationDto.getDegree();;
//        this.startYear = educationDto.getStartYear();;
//        this.endYear = educationDto.getEndYear();;
//        this.fieldOfStudy = educationDto.getFieldOfStudy();;
//        this.location = educationDto.getLocation();;
//        this.description = educationDto.getDescription();;
//    }
    public Education(String id,String institution, String degree, int startYear, int endYear, String fieldOfStudy, String location, String description) {
        this.id=id;
        this.institution = institution;
        this.degree = degree;
        this.startYear = startYear;
        this.endYear = endYear;
        this.fieldOfStudy = fieldOfStudy;
        this.location = location;
        this.description = description;
    }
    public void setId(String id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public void setFieldOfStudy(String fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    public void setLocation(String location) {
        this.location = location;
    }
// Constructors, getters, setters
}

