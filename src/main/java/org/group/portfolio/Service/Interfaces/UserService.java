package org.group.portfolio.Service.Interfaces;

import org.group.portfolio.Dto.UserDto;
import org.group.portfolio.Entities.User;

public interface UserService {
    public User SaveUser(UserDto userDto);
    public User AuthenticateUser(String email);
    public User UpdateUser(String id,UserDto userDto);
}
