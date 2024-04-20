package org.group.portfolio.Entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Education")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
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
}

