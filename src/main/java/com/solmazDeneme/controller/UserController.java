package com.solmazDeneme.controller;


import com.solmazDeneme.dto.UserRegistrationDto;
import com.solmazDeneme.model.Day;
import com.solmazDeneme.model.User;
import com.solmazDeneme.repository.DayRepository;
import com.solmazDeneme.repository.UserRepository;
import com.solmazDeneme.service.DayService;
import com.solmazDeneme.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;


@Controller
public class UserController {


    private IUserService userService;
    private DayService dayService;


    private UserRepository userRepository;
    private DayRepository dayRepository;

    public UserController( IUserService userService,
                           UserRepository userRepository) {
        super();
        this.userService = userService;
        this.userRepository = userRepository;
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

//    @PostMapping("/account")
//    public String myAccountPost(Principal principal){
//        try {
//
//            User existingUser = userService.getUserByEmail(principal.getName());
//            UserCalendar userCalendar1 = new UserCalendar(principal.getName());
//            userRepository.save(existingUser);
//
//
//
//            return "account";
//
//        }catch (Exception e){
//            return "login";
//        }
//
//
//    }
//    *******************************
//
//
//
    @ModelAttribute("myDay")
    public Day Day(){
        return new Day();
    }

    @PostMapping("/account")
    public String saveDay(@ModelAttribute("myDay") Day day,Principal principal){

        User existingUser = userService.getUserByEmail(principal.getName());

        Day day1 = new Day(day.getPersonDay());

        existingUser.getDays().add(day1);
        this.userRepository.save(existingUser);

        return "redirect:/account";
    }


}
