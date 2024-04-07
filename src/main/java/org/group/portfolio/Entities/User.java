package org.group.portfolio.Entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class User
{
    @Id
    private String Id;
    private String name;
    private String password;
    private String tel;
    private String email;

}