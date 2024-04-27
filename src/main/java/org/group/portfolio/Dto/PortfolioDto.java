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
    String id;
    User user;
    private String color;
    private String name;
    private boolean visible;
    private CategoriePort categorie;
    List<Experience> experiences;
    List<Project> projects;
    List<Education> educations;

}
