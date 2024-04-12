package org.group.portfolio.Entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.List;

@Document(collection = "Users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class User
{
    @Id
    private String id;
    private String name;
    private String password;
    private String tel;
    @Indexed(unique = true)
    private String email;
//    @DBRef
//    List<Education> educationsCache;
//    @DBRef
//    List<Experience> experiencesCache;
}