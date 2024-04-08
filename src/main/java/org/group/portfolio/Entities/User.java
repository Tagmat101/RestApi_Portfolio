package org.group.portfolio.Entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.Indexed;
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

}