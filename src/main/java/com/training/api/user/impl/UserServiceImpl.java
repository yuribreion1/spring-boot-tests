package com.training.api.user.impl;

import com.training.api.exception.DataIntegrityViolationException;
import com.training.api.user.User;
import com.training.api.user.dto.UserDTO;
import com.training.api.user.UserRepository;
import com.training.api.user.UserService;
import com.training.api.exception.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public User findById(Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User create(UserDTO userDTO) {
        findByEmail(userDTO);
        return userRepository.save(modelMapper.map(userDTO, User.class));
    }

    @Override
    public User update(UserDTO userDTO) {
        findByEmail(userDTO);
        return userRepository.save(modelMapper.map(userDTO, User.class));
    }

    private boolean findByEmail(UserDTO userDTO) {
        if (userRepository.findByEmail(userDTO.getEmail()).isPresent() && !userDTO.getId().equals(userDTO.getId())) {
            throw new DataIntegrityViolationException("User already exists");
        } else return true;
    }
}
