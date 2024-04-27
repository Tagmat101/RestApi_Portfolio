package org.group.portfolio.Config;
import org.group.portfolio.Dto.*;
import org.group.portfolio.Entities.*;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

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

        modelMapper.createTypeMap(Education.class, EducationDto.class);
        modelMapper.createTypeMap(Experience.class, ExperienceDto.class);
        modelMapper.createTypeMap(Project.class, ProjectDto.class);
        modelMapper.createTypeMap(Skill.class, SkillDto.class);

        modelMapper.createTypeMap(CategoriePort.class,CategoriePortDto.class);
        modelMapper.createTypeMap(Portfolio.class, PortfolioDto.class)
                .addMapping(Portfolio::getUser,PortfolioDto::setUser);
        return modelMapper;
    }
}
