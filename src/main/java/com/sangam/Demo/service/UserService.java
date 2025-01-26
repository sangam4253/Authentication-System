package com.sangam.Demo.service;

import com.sangam.Demo.model.User;
import com.sangam.Demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
    	return userRepository.save(user); // Save user to the database
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null); // Retrieve user by ID
    }
}
