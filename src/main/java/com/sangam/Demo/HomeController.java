package com.sangam.Demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String register() {
        // Return the name of the Thymeleaf template (index.html without the extension)
        return "register";
    }
    @RequestMapping("/forget-password")
    public String forgetPassword() {
        // Return the name of the Thymeleaf template (index.html without the extension)
        return "forget-password";
    }
}
