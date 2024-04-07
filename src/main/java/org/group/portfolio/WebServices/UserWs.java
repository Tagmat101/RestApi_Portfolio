package org.group.portfolio.WebServices;

import org.group.portfolio.Dto.UserDto;
import org.group.portfolio.Entities.User;
import org.group.portfolio.Response.ApiResponse;
import org.group.portfolio.Service.Interfaces.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class  UserWs {
    @Autowired // it will call the specific class that implements this interface in this case it's UserServiceiMP
    private UserService userService;
    ModelMapper modelMapper = new ModelMapper();
    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<User>> SignUp(@RequestBody UserDto userDto)
    {
       User save = userService.SaveUser(userDto);
       ApiResponse<User> response = new ApiResponse<>(200, "User Created  successfully", save);
       return ResponseEntity.ok(response);
    }
    @PostMapping("/signin")
    public ResponseEntity<ApiResponse<User>> Login(@RequestBody UserDto userDto)
    {
        String email = userDto.getEmail();
        User user = userService.AuthenticateUser(email);
        ApiResponse<User> response = new ApiResponse<>(200, "User Logged in successfully", user);
        return ResponseEntity.ok(response);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<User>> Update(@PathVariable String id , @RequestBody UserDto userDto)
    {
        User user = userService.UpdateUser(id,userDto);
        ApiResponse<User> response = new ApiResponse<>(200, "User updated successfully", user);
        return ResponseEntity.ok(response);
    }
}
