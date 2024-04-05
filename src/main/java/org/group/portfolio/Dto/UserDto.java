package org.group.portfolio.Dto;

import lombok.Data;

@Data
public class UserDto {
    private int id;
    private String name;

    public UserDto(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
