package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/user")
public class UserController {
//user dashboard page

@RequestMapping(value="/dashboard")
public String userDashboard() {
    return "user/dashboard";
}
//User profile page

@RequestMapping(value="/profile")
public String userProfile() {
    return "user/profile";
}


//user add contacts page


//ser view contacts


//user add contacts page

}
