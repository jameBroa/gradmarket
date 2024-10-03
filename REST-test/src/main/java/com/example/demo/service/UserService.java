package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.model.Users;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// Doesn't need to be an interface, so it won't be
//        The service layer (domain) contains your business logic.
//        It defines which functionalities you provide, how they are
//        accessed, and what to pass and get in return
// Handles setup for userRepository and necessary to access persistance layer

// Will have transactional methods

// This is where the controller will communicate with the service layer


@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public Iterable<UserDto> getAllUsers() {
        Iterable<Users> allUsers = userRepository.findAll();
        return convertIterableUserToDto(allUsers);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public void createUser(Users newUser) {
        userRepository.save(newUser);
    }

    public UserDto convertToDTO(Users users) {
        return new UserDto(users.getUsername(),
                users.getFirstName(), users.getLastName(), users.getEmail(), users.getId(),
                users.getUniversity());
    }

    public Iterable<UserDto> convertIterableUserToDto(Iterable<Users> iterableUsers) {
        List<UserDto> iterableUserDtos = new ArrayList<>();

        for(Users user : iterableUsers) {
            UserDto userDto = convertToDTO(user);
            iterableUserDtos.add(userDto);
        }
        return iterableUserDtos;
    }



}
