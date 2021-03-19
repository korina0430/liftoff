package org.launhcode.healthynutrition.controllers;

import org.launhcode.healthynutrition.data.UserRepository;
import org.launhcode.healthynutrition.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class UserController {
@Autowired
  private UserRepository userRepo;

    @GetMapping("/signup")
    public String getSignup(){
        return "signup";
    }

    @PostMapping("/signup")
    public String displaySignupPage(Model model, User user){
        model.addAttribute("user");
        userRepo.save(user);
        return "redirect:";

    }


    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String displayLoginPage(Model model, User user) {
        model.addAttribute("user");
        userRepo.save(user);
        return "redirect:";
//        return "/loginPage";
    }

}
