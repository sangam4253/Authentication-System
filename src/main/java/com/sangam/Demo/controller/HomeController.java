package com.sangam.Demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import com.sangam.Demo.model.User;
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
}
