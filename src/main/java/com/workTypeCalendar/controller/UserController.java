package com.workTypeCalendar.controller;


import com.workTypeCalendar.model.Day;
import com.workTypeCalendar.model.User;
import com.workTypeCalendar.model.WorkType;
import com.workTypeCalendar.repository.DayRepository;
import com.workTypeCalendar.repository.UserRepository;
import com.workTypeCalendar.service.DayService;
import com.workTypeCalendar.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;


@Controller
public class UserController {


    private IUserService userService;
    private UserRepository userRepository;
    private final DayRepository dayRepository;

    public UserController(IUserService userService,
                          UserRepository userRepository,
                          DayRepository dayRepository) {
        super();
        this.userService = userService;
        this.userRepository = userRepository;
        this.dayRepository = dayRepository;
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

    @ModelAttribute("myDay")
    public Day Day(){
        return new Day();
    }

    @PostMapping("/account")
    public String saveDay(@ModelAttribute("myDay") Day day,Principal principal){

        User existingUser = userService.getUserByEmail(principal.getName());
        Day day1 = new Day(day.getPersonDay(),day.getChooseWorkType());

        if(dayRepository.existsByPersonDayAndUsers(day1.getPersonDay(),existingUser)){

            Day existingDay = dayRepository.findByPersonDayAndUsers(day1.getPersonDay(),existingUser);
            existingDay.setChooseWorkType(day1.getChooseWorkType());
        }else{
            existingUser.getDays().add(day1);
        }
        this.userRepository.save(existingUser);
        return "redirect:/account";
    }
}
