package org.group.portfolio.Config;

import org.group.portfolio.Dto.UserDto;
import org.group.portfolio.Entities.User;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        // Add mappings for User and UserDTO
        modelMapper.createTypeMap(User.class, UserDto.class)
                .addMapping(User::getEmail, UserDto::setEmail)
                .addMapping(User::getPassword, UserDto::setPassword)
                .addMapping(User::getName, UserDto::setName)
                .addMapping(User::getTel,UserDto::setTel);
        return modelMapper;
    }
}
