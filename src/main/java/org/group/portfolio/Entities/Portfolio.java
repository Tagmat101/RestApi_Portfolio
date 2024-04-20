package org.group.portfolio.Entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Document(collection = "Portfolio")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class Portfolio
{
    @Id
    private String id;
    private String color;
    private String name;
    private boolean visibility;
    @DBRef
    private User user;
    @DBRef
    List<Experience> experiences;
    @DBRef
    List<Project> projects;
    @DBRef
    List<Skill> skills;
    @DBRef
    List<Education> educations;
    @DBRef
    CategoriePort categorie;
}
