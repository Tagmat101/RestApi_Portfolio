package org.group.portfolio.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.group.portfolio.Entities.Education;
import org.group.portfolio.Entities.Experience;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String name;
    private String email;
    private String password;
    private String tel;
//    List<Experience> experiencesCache;
//    List<Education> educationsCache;
}
