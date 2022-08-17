package com.solmazDeneme.controller;

import com.solmazDeneme.dto.UserRegistrationDto;
import com.solmazDeneme.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    private IUserService iUserService;

    public UserRegistrationController(IUserService iUserService) {
        super();
        this.iUserService = iUserService;
    }


    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto(){
        return new UserRegistrationDto();
    }


    @GetMapping
    public String showRegistrationForm(){

        return "registration";
    }


    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto ){

        try {

            iUserService.save(registrationDto);

            return "redirect:/registration?success";

        }catch (Exception e){

            return "redirect:/registration?error";
        }
    }

}
