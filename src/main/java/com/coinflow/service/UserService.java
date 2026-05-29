package com.coinflow.service;

import org.springframework.stereotype.Service;

import com.coinflow.entity.User;
import com.coinflow.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(String firstName, String lastName, String password, String email) {
        User user = new User();

        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(password);
        user.setEmail(email);

        return userRepository.save(user);
    }

}
