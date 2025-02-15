package com.sangam.Demo.controller;

import com.sangam.Demo.model.User;
import com.sangam.Demo.service.UserService;
import com.sangam.Demo.service.EmailService;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.util.UUID;

@Controller
@RequestMapping("/api")
public class ForgotPasswordController {

    private final UserService userService;
    private final EmailService emailService;

    public ForgotPasswordController(UserService userService, EmailService emailService) {
        this.userService = userService;
        this.emailService = emailService;
    }

    @GetMapping("/forgot-password")
    public String forgotPasswordPage() {
        return "forgot-password";
    }

    @PostMapping("/forgot-password")
    public String processForgotPassword(@RequestParam String email, Model model) {
        User user = userService.findByEmail(email);

        if (user != null) {
            String token = UUID.randomUUID().toString();
            userService.savePasswordResetToken(user, token);

            String resetLink = "http://localhost:8080/api/reset-password?token=" + token;
            emailService.sendEmail(user.getEmail(), "Password Reset Request",
                    "Click the link to reset your password: " + resetLink);

            model.addAttribute("message", "Password reset link sent to your email!");
        } else {
            model.addAttribute("error", "Email not found!");
        }
        return "forget-password";
    }
    @GetMapping("/reset-password")
    public String resetPassword1(@RequestParam String token, Model model) {
    
    	User user = userService.findByPasswordResetToken(token);
    	model.addAttribute("token", token);
    	return "reset-password";
    }
    
    @PostMapping("/reset-password")
    public String resetPassword(@RequestParam String token,
                                @RequestParam String password,
                                @RequestParam String confirmPassword,
                                Model model) {
        if (!password.equals(confirmPassword)) {
            model.addAttribute("error", "Passwords do not match!");
            return "reset-password";
        }

        User user = userService.findByPasswordResetToken(token);
        if (user == null) {
            model.addAttribute("error", "Invalid or expired token!");
            return "reset-password";
        }

        userService.updatePassword(user, password);
        model.addAttribute("message", "Password reset successful! You can now login.");
        return "index";
    }

}
