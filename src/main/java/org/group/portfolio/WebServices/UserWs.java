package org.group.portfolio.WebServices;

import org.group.portfolio.Dto.UserDto;
import org.group.portfolio.Entities.User;
import org.group.portfolio.Respository.UserRepository;
import org.group.portfolio.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserWs {
    @Autowired
    private UserService userService;
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public String createUser(@RequestBody UserDto userDto)
    {
        System.out.println(userDto.getId());
        System.out.println(userDto.getName());
       return userService.createUser(userDto);
    }
}
