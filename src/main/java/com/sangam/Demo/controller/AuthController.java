package com.sangam.Demo.controller;

import com.sangam.Demo.model.User;
import com.sangam.Demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/api/users")
public class AuthController {

    @Autowired
    private UserService userService;

    // Register a new user
    @PostMapping("/register")
    public String registerUser(@RequestParam String name, 
            @RequestParam String email, 
            @RequestParam String password, 
             Model model) {
        try {
        	//System.out.println(name);
        	 User newUser = new User();
             newUser.setName(name);
             newUser.setEmail(email);
             newUser.setPassword(password);
            userService.registerUser(newUser);
            model.addAttribute("message", "User registered successfully!");
    
            return "redirect:/login"; // Return the saved user with 200 OK
        } catch (Exception e) {
            return "redirect:/register"; // Return 400 Bad Request for errors
        }
    }

}
