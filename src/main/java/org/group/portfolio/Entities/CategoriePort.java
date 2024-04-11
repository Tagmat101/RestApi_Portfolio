package org.group.portfolio.Entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "CategoriePort")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CategoriePort {
    @Id
    private String id;
    private String name;
    private boolean state;
    @DBRef
    private User user;
}
