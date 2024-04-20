package org.group.portfolio.Entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "Project")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Project {
    @Id
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
