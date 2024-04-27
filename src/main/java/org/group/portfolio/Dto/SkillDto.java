package org.group.portfolio.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.group.portfolio.Entities.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SkillDto {
    private String name;
    private String icon;
    private String type;//.type("Hard")
    private String category;// "Software Development")
    User user;
}

