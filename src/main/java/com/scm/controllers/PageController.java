package com.scm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.entities.User;
import com.scm.forms.UserForm;
import com.scm.helpers.Message;
import com.scm.helpers.MessageType;
import com.scm.services.UserService;

import jakarta.servlet.http.HttpSession;


@Controller
public class PageController {

    @Autowired
    private UserService userService;

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
    public String processRegister(@ModelAttribute UserForm userForm, HttpSession session) {
        System.out.println("processing registration");

        System.out.println(userForm);


        // User user=User.builder()
        // .name(userForm.getName())
        // .email(userForm.getEmail())
        // .password(userForm.getPassword())
        // .about(userForm.getAbout())
        // .phoneNumber(userForm.getPhoneNumber())
        // .ProfilePic("https://avatars.githubusercontent.com/u/92136795?v=4&size=64")
        // .build();
        User user=new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getPhoneNumber());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setProfilePic("https://avatars.githubusercontent.com/u/92136795?v=4&size=64");


        User savedUser= userService.saveUser(user);

        Message message=Message.builder().content("Registration Successfull").type(MessageType.green).build();

        session.setAttribute("message",message);

        System.out.println("user saved");
        return "redirect:/register";
    }
    
    
}
