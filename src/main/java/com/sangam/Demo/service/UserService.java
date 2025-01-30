package com.sangam.Demo.service;

import com.sangam.Demo.model.User;
import com.sangam.Demo.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    public User registerUser(User user) {   
    	return userRepository.save(user); // Save user to the database
    }

    public void savePasswordResetToken(User user, String token) {
        user.setResetToken(token);
        userRepository.save(user);
    }

    public User findByPasswordResetToken(String token) {
        return userRepository.findByResetToken(token);
    }

    public void updatePassword(User user, String password) {
        user.setPassword(passwordEncoder.encode(password));
        user.setResetToken(null); // Clear token after reset
        userRepository.save(user);
    }
}

