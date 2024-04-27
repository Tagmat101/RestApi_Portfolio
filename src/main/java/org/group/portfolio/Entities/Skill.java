package org.group.portfolio.Entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
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
    private String icon;
    private String type;//.type("Hard")
    private String category;// "Software Development")
    @DBRef
    private User user;

}
