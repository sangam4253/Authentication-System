package com.sangam.Demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import com.sangam.Demo.model.User;

import jakarta.servlet.http.HttpSession;
@Controller
public class HomeController {
	 
    @RequestMapping("/")
    public String home() {
        // Return the name of the Thymeleaf template (index.html without the extension)
        return "index";
    }
    @RequestMapping("/login")
    public String login() {
        // Return the name of the Thymeleaf template (index.html without the extension)
        return "index";
    }
    @RequestMapping("/register")
    public String registerView(Model model) {
    	 User user = new User();
         model.addAttribute("user", user);
        return "register";
    }
    @RequestMapping("/forget-password")
    public String forgetPassword() {
        // Return the name of the Thymeleaf template (index.html without the extension)
        return "forget-password";
    }
    @RequestMapping("/dashboard")
    public String dashboardPage(HttpSession session, Model model) {
    	 User user = (User) session.getAttribute("loggedInUser");

         if (user == null) {
             // Redirect to login if no user is logged in
             return "redirect:/login";
         }

         // Add user details to the model
         model.addAttribute("user", user);
        return "dashboard"; // Returns the "dashboard.html" template.
    }
}
