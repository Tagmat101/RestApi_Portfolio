package org.group.portfolio.ServiceTest;

import org.group.portfolio.Dto.UserDto;
import org.group.portfolio.Entities.User;
import org.group.portfolio.Respository.UserRepository;
import org.group.portfolio.Service.Implementations.UserServiceImp;
import org.group.portfolio.Service.Interfaces.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    private UserService userService;
    AutoCloseable autoCloseable;
    UserDto userDto;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        userService = new UserServiceImp();  // Assuming constructor injection
        userDto = new UserDto("12", "halmza", "1234", "1031", null);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void testCreateUser() {
        User expectedUser = new User("12", "halmza", "1234", "1031","dlzq");
        when(userRepository.save(any(User.class))).thenReturn(expectedUser);
        User result = userService.SaveUser(userDto);
        assertThat(result).isEqualTo(expectedUser);
    }

}