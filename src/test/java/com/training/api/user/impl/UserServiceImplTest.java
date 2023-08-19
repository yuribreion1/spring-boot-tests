package com.training.api.user.impl;

import com.training.api.exception.ObjectNotFoundException;
import com.training.api.user.User;
import com.training.api.user.UserRepository;
import com.training.api.user.dto.UserDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceImplTest {

    public static final int ID = 1;
    public static final String NAME = "Yuri";
    public static final String MAIL = "yuri@mail.com";
    public static final String PASSWORD = "1234";

    // Inject service implementation using the real methods and data
    @InjectMocks
    UserServiceImpl userService;

    // Mock annotation enable the repository using mock data
    @Mock
    UserRepository userRepository;

    // Mock annotation enable the repository using mock data
    @Mock
    ModelMapper modelMapper;

    User user;

    UserDTO userDTO;

    Optional<User> optionalUser;

    @BeforeEach
    void setUp() {
        // this is a mention of UserServiceImpl
        MockitoAnnotations.openMocks(this);
        startUser();
    }

    @Test
    @DisplayName("Testing findById method")
    void whenFindByIdThenReturnsAnUserInstance() {
                when(userRepository
                        .findById(anyInt()))
                .thenReturn(optionalUser);
        User userResponse = userService.findById(ID);
        assertEquals(User.class, userResponse.getClass());
    }

    @Test
    @DisplayName("Testing findById not found")
    void whenFindByIdThenReturnObjectNotFoundException() {
        when(userRepository.findById(anyInt())).thenThrow(new ObjectNotFoundException("Object not found"));

        try{
            userService.findById(ID);
        } catch (Exception e) {
            assertEquals("Object not found", e.getMessage());
        }
    }

    @Test
    void findAll() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    void startUser() {
        user = new User(ID, NAME, MAIL, PASSWORD);
        userDTO = new UserDTO(ID, NAME, MAIL, PASSWORD);
        optionalUser = Optional.of(new User(ID, NAME, MAIL, PASSWORD));
    }
}