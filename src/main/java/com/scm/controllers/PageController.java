package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.forms.UserForm;


@Controller
public class PageController {

    @GetMapping("/home")
    public String homePage(Model model) {
        model.addAttribute("name", "Spring User");
        model.addAttribute("youtube", "https://www.youtube.com/springboot");
        model.addAttribute("githubRepo", "https://github.com/yourrepo");

        return "home"; // Matches home.html in templates folder
    }

    @RequestMapping("/about")
    public String aboutPage(Model model) {
        model.addAttribute("isLogin", false); // Set this dynamically based on user authentication
        return "about";
    }

    @RequestMapping("/services")
    public String servicePage() {
        return "services";
    }

    @GetMapping("/contact")
    public String contact() {
        return new String("contact");
    }
    
    @GetMapping("/login")
    public String login() {
        return new String("login");
    }
    
    @GetMapping("/register")
    public String register(Model model) {
        UserForm userForm=new UserForm();
        // userForm.setName("kishan");
        //
        model.addAttribute("userForm", userForm);

        return "register"; // Ensure "register.html" exists in your templates folder
    }
    


    //processing register

    @PostMapping(value = "/do-register")
    public String processRegister() {
        System.out.println("processing registration");
        return "redirect:/register";
    }
    
    
}
