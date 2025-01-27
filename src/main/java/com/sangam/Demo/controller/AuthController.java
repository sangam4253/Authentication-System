package com.sangam.Demo.controller;

import com.sangam.Demo.model.User;
import com.sangam.Demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import jakarta.servlet.http.HttpSession;

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
    @PostMapping("/login")
    public String loginUser(@RequestParam String email, 
                            @RequestParam String password, 
                            Model model,HttpSession session) {
        // Validate user credentials
        User user = userService.findByEmail(email); // Fetch user by email.

        if (user != null && user.getPassword().equals(password)) {
            // If credentials are valid, redirect to the dashboard.
            model.addAttribute("message", "Login successful!");
            session.setAttribute("loggedInUser", user);

            return "redirect:/dashboard"; // Redirects to dashboard mapping.
        } else {
            // If invalid credentials, reload login with an error message.
            model.addAttribute("error", "Invalid email or password!");
            return "login"; // Reload login page with error.
        }
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // Invalidate the session
        session.invalidate();
        return "redirect:/login";
    }
    

}
