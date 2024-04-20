package org.group.portfolio.Entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;
@Document(collection = "Experience")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Experience {
    @Id
    private String id;
    private String companyName;
    private String jobTitle;
    private Date startDate;
    private Date endDate;
    private String description;
    private String[] responsibilities;
    private String[] achievements;
    private Skill[] skills;

}
