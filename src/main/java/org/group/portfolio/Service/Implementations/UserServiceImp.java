package org.group.portfolio.Service.Implementations;
import org.mindrot.jbcrypt.BCrypt;
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
    @Autowired
    ModelMapper modelMapper = new ModelMapper();
    public User SaveUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        String hashedPassword = BCrypt.hashpw(user.getPassword(),BCrypt.gensalt());
        user.setPassword(hashedPassword);
        return userRepository.save(user);
    }

    public User AuthenticateUser(UserDto userDto) {
        User user = userRepository.findByEmail(userDto.getEmail());
        if (user == null) {
            throw new AppException("No User found with this email");
        }

        if (BCrypt.checkpw(userDto.getPassword(), user.getPassword())) {
            return user;
        }

        throw new AppException("Password Incorrect");
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
    @Override
    public void DeleteUser(String id)
    {
        /*
          find it first then delete (not using deleteById considered as a mistake because
          there is a possibility that we can not have that id provided )
         */
        User user = userRepository.findById(id).orElse(null);
        if(user == null) throw new AppException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
        userRepository.deleteById(user.getId());
    }
}
