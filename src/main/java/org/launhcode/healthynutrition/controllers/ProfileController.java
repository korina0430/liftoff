package org.launhcode.healthynutrition.controllers;


import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.launhcode.healthynutrition.data.UserRepository;
import org.launhcode.healthynutrition.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profile")
public class ProfileController {


    @Autowired
    private UserRepository userRepo;

    @GetMapping
    public String profileForm(HttpSession session, Model model) {
    	Integer userId = (Integer) session.getAttribute(AuthenticationController.USER_SESSION_KEY);
    	if (userId == null) {
    		return "redirect:/login";
    	}
    	return displayEditProfileForm(model, userId);    	
    }


    @GetMapping("/{id}")
    public String displayEditProfileForm(Model model, @PathVariable("id") int id) {

        Optional<User> profileId = userRepo.findById(id);
        model.addAttribute("user", profileId.get());
        return "profile";
    }

    
    @PostMapping
    public String createProfile(HttpSession session, Model model, User input) {
       	Integer userId = (Integer) session.getAttribute(AuthenticationController.USER_SESSION_KEY);
    	if (userId == null) {
    		return "redirect:/login";
    	}
        
    	Optional<User> userFromDb = userRepo.findById(userId);
    	if (userFromDb.isPresent()) {
    		User user = userFromDb.get();
    		user.setAge(input.getAge());
    		user.setContactNumber(input.getContactNumber());
    		
    		userRepo.save(user);
    		model.addAttribute("user", user);
    	}


        
    	
    	
        return "redirect:";
    }

    

    @PostMapping("/{id}")
    public String saveEditProfile(Model model, @PathVariable("id") Integer id, User user) {
        if (id == null) {
            return "redirect:";
        }

        Optional<User> userId = userRepo.findById(id);
        if (userId.isPresent()) {
            user.setFirstName(userId.get().getFirstName());
            user.setLastName(userId.get().getLastName());
            user.setUsername(userId.get().getEmail());
            user.setGender(userId.get().getGender());
            user.setAge(userId.get().getAge());
            user.setContactNumber(userId.get().getContactNumber());

        }


        userRepo.save(user);
        model.addAttribute("user", userRepo.save(user));
        return "profile";

    }

    @PostMapping("/delete/{id}")
    public String deleteProfileId(@PathVariable("id") Integer id){
        if(id != null) {
            userRepo.deleteById(id);
        }
        return "redirect:/profile";
    }

    @PostMapping("/delete")
    public String deleteProfile(HttpSession session){
       	Integer userId = (Integer) session.getAttribute(AuthenticationController.USER_SESSION_KEY);
    	if (userId == null) {
    		return "redirect:/login";
    	}

    	session.invalidate();
    	return deleteProfileId(userId);
    }
    

}







