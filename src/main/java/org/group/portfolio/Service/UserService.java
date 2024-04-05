package org.group.portfolio.Service;

import org.group.portfolio.Dto.UserDto;
import org.group.portfolio.Entities.User;
import org.group.portfolio.Respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public String createUser(@RequestBody UserDto userDto) {
        try
        {
            User ussr = User.builder()
                    .name(userDto.getName()).build();
            userRepository.save(ussr);
        } catch(Exception e)
        {

        }
        return "created";
    }
}
