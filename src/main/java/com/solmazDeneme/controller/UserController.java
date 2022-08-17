package com.solmazDeneme.controller;


import com.solmazDeneme.dto.UserRegistrationDto;
import com.solmazDeneme.model.User;
import com.solmazDeneme.repository.UserRepository;
import com.solmazDeneme.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;


    @Autowired
    private UserRepository userRepository;

    public UserController( IUserService userService) {
        super();
        this.userService = userService;
    }

    //handler method to handle list students and return mode and view
    @GetMapping("/users")
    public String listUsers(Model model){
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @PostMapping("/users/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute("user") User user){

        //get user from database by id
        User existingUser = userService.getUserById(id);

        existingUser.setActive(!existingUser.isActive());

        //save updated user object
        userService.updateUser(existingUser);

        return "redirect:/users";
    }

    @GetMapping("/account")
    public String myAccount(Principal principal,Model model){

        User existingUser = userService.getUserByEmail(principal.getName());

        model.addAttribute("myUser", existingUser);
        return "account";
    }


    @PostMapping("/account")
    public String myAccountPost(Principal principal,@ModelAttribute("myUser") User user){
        try {
            User existingUser = userService.getUserByEmail(principal.getName());

            existingUser.setDayPlan(user.getDayPlan());
            userService.updateUser(existingUser);

            return "redirect:/account";

        }catch (Exception e){
            return "login";
        }


    }




}
