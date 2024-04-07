package org.group.portfolio.Service.Implementations;

import org.group.portfolio.Dto.UserDto;
import org.group.portfolio.Entities.User;
import org.group.portfolio.Exceptions.AppException;
import org.group.portfolio.Response.ErrorMessages;
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

        return userRepository.save(user);
    }

    public User AuthenticateUser(String email)
    {
        User user = userRepository.findByEmail(email);
        if(user == null) throw new AppException("No User found with this email");
        return user;
    }

    @Override
    public User UpdateUser(String id, UserDto userDto) {
        User user = userRepository.findById(id).orElse(null);
        if(user == null) throw new AppException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
        user.setEmail(userDto.getEmail());
        user.setTel(userDto.getTel());
        user.setName(userDto.getName());
        userRepository.save(user);
        return user;
    }
}
