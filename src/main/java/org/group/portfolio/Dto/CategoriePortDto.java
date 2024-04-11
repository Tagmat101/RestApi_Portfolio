package org.group.portfolio.Dto;

import lombok.*;
import org.group.portfolio.Entities.Portfolio;
import org.group.portfolio.Entities.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CategoriePortDto {
    private String id;
    private String name;
    private boolean state;
    private User user;
}
