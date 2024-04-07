package org.group.portfolio.WebServices;
import org.group.portfolio.Dto.UserDto;
import org.group.portfolio.Entities.User;
import org.group.portfolio.Request.UserRequest;
import org.group.portfolio.Response.ApiResponse;
import org.group.portfolio.Service.Interfaces.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserWs {
    @Autowired // it will call the specific class that implements this interface in this case it's UserServiceiMP
    private UserService userService;
    ModelMapper modelMapper = new ModelMapper();
    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<String>> SignUp(@RequestBody UserRequest userRequest)
    {
       UserDto userDto = modelMapper.map(userRequest, UserDto.class);
       User user = userService.SaveUser(userDto);
       ApiResponse<String> response = new ApiResponse<>(200, "User Created  successfully", user.getId());
       return ResponseEntity.ok(response);
    }
    @PostMapping("/signin")
    public ResponseEntity<ApiResponse<String>> Login(@RequestBody UserDto userDto)
    {
        User user = userService.SaveUser(userDto);
        ApiResponse<String> response = new ApiResponse<>(200, "User Logged in successfully", user.toString());
        return ResponseEntity.ok(response);
    }
}
