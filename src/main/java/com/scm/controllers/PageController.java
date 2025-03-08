package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    
    
}
