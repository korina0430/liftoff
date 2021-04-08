package org.launhcode.healthynutrition.controllers;


import org.launhcode.healthynutrition.data.UserRepository;
import org.launhcode.healthynutrition.models.Profile;
import org.launhcode.healthynutrition.models.User;
import org.launhcode.healthynutrition.models.data.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private ProfileRepository repository;

    @Autowired
    private UserRepository userRepo;


    @GetMapping
    public String profileForm(Model model) {
        model.addAttribute("profile", new Profile());
        return "profile";
    }

    @PostMapping
    public String createProfile(Model model, Profile profile) {
        ;
        model.addAttribute("profile");
        repository.save(profile);
        return "redirect:";
    }

    @GetMapping("/{id}")
    public String displayEditProfileForm(Model model, @PathVariable("id") int id) {

        Optional<Profile> optional = repository.findById(id);
        Profile profile =  null;
        if (optional.isEmpty()) {
            profile = new Profile();

            Optional<User> optionalUser = userRepo.findById(id);
            if (optionalUser.isPresent()) {
                profile.setUser(optionalUser.get());
            }
        } else {
            profile = optional.get();
        }

        model.addAttribute("profile", profile);
        return "profile";
    }


    @PostMapping("/{id}")
    public String saveEditProfile(Model model, @PathVariable("id") Integer id, Profile profile) {
        if (id == null) {
            return "redirect:";
        }

        Optional<User> user = userRepo.findById(id);
        if (user.isPresent()) {
            profile.getUser().setPwHash(user.get().getPwHash());
            profile.getUser().setUsername(user.get().getEmail());
        }

        profile.setId(id);
        profile.getUser().setId(id);
        model.addAttribute("profile", repository.save(profile));
        return "profile";

    }
}







