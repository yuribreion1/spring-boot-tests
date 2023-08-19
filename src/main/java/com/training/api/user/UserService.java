package com.training.api.user;

import com.training.api.user.dto.UserDTO;

import java.util.List;

public interface UserService {

    User findById(Integer id);

    List<User> findAll();

    User create(UserDTO userDTO);

    User update(UserDTO userDTO);

    User delete(Integer id);
}
