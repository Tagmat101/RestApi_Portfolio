package org.group.portfolio.WebServices;
import org.group.portfolio.Dto.UserDto;
import org.group.portfolio.Entities.User;
import org.group.portfolio.Response.ApiResponse;
import org.group.portfolio.Response.ErrorMessages;
import org.group.portfolio.Service.Interfaces.UserService;
import org.group.portfolio.Utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserWs {
    @Autowired
    private UserService userService;
    @Autowired
    JwtUtil jwtUtil;
    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<User>> SignUp(@RequestBody UserDto userDto) {
        User save = userService.SaveUser(userDto);
        ApiResponse<User> response = new ApiResponse<>(200, "User Created successfully", save);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/signin")
    public ResponseEntity<ApiResponse<String>> Login(@RequestBody UserDto userDto) {
        User user = userService.AuthenticateUser(userDto);
        String token = jwtUtil.generateToken(user.getId());
        ApiResponse<String> response = new ApiResponse<>(200, "User Logged in successfully", token);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<User>> Update(@PathVariable String id, @RequestBody UserDto userDto,@RequestHeader("Authorization") String token) {
        if(!jwtUtil.validateToken(token)){
            ApiResponse<User> notFoundResponse = new ApiResponse<>(401, "UnAuthorized", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFoundResponse);
        }
        User user = userService.UpdateUser(id, userDto);
        ApiResponse<User> response = new ApiResponse<>(200, "User updated successfully", user);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> Delete(@PathVariable String id,@RequestHeader("Authorization") String token) {
        if(!jwtUtil.validateToken(token)){
            ApiResponse<String> notFoundResponse = new ApiResponse<>(404, "UnAuthorized", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFoundResponse);
        }
        userService.DeleteUser(id);
        ApiResponse<String> apiResponse = new ApiResponse<>(200, "User deleted successfully", id);
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<User>> GetUserById(@PathVariable String id, @RequestHeader("Authorization") String token) {
        User user = userService.GetUserById(id);
        if(!jwtUtil.validateToken(token)){
            ApiResponse<User> notFoundResponse = new ApiResponse<>(404, "UnAuthorized", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFoundResponse);
        }
        ApiResponse<User> apiResponse = new ApiResponse<>(200, "User found", user);
        return ResponseEntity.ok(apiResponse);
    }

 }
