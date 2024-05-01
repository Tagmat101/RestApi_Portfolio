package org.group.portfolio.Entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

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
    private String employmentType;
    private Date endDate;
    private String description;
    private String[] responsibilities;
    private String[] achievements;
    @DBRef
    private List<Skill> skills;
    private String location;
    @DBRef
    private User user;
}
