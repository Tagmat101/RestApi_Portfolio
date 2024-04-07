package org.group.portfolio.Service.Implementations;

import org.group.portfolio.Dto.UserDto;
import org.group.portfolio.Entities.User;
import org.group.portfolio.Respository.UserRepository;
import org.group.portfolio.Service.Interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;
    public String createUser(UserDto userDto) {
        try
        {
            User ussr = User.builder()
                    .Id(userDto.getId())
                    .name(userDto.getName()).build();
            userRepository.save(ussr);
        } catch(Exception e)
        {
            return "Faulty : " + e.getMessage();
        }
        return "created";
    }
}
