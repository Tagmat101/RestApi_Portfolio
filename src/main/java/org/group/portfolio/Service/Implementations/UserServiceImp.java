package org.group.portfolio.Service.Implementations;

import org.group.portfolio.Dto.UserDto;
import org.group.portfolio.Entities.User;
import org.group.portfolio.Exceptions.AppException;
import org.group.portfolio.Respository.UserRepository;
import org.group.portfolio.Service.Interfaces.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;
    ModelMapper modelMapper = new ModelMapper();
    public User SaveUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);

        if(userRepository.findByEmail(user.getEmail()) != null) throw new AppException("This user already exist with this email");
        return userRepository.save(user);
    }

    public User AuthenticateUser(String email)
    {
        User user = userRepository.findByEmail(email);
        if(user == null) throw new AppException("No User found with this email");
        return user;
    }
}
