package org.group.portfolio.WebServices;

import org.group.portfolio.Dto.UserDto;
import org.group.portfolio.Service.Implementations.UserServiceImp;
import org.group.portfolio.Service.Interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserWs {
    @Autowired // it will call the specific class that implements this interface in this case it's UserServiceiMP
    private UserService userService;
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public String createUser(@RequestBody UserDto userDto)
    {
        System.out.println(userDto.getId());
        System.out.println("");
       return userService.createUser(userDto);
    }
}
