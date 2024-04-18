package org.group.portfolio.Entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Skill")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Skill {
    @Id
    private String id;
    private String name;

}
