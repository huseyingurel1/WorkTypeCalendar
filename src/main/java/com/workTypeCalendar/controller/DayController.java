//package com.solmazDeneme.controller;
//
//import com.solmazDeneme.model.Day;
//import com.solmazDeneme.service.DayService;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//
//@Controller
//public class DayController {
//
//    private DayService dayService;
//
//    public DayController(DayService dayService) {
//        super();
//        this.dayService = dayService;
//    }
//
//    @GetMapping("/days")
//    public String listStudents(Model model){
//        model.addAttribute("days", dayService.getAllDays());
//        return "account";
//    }
//
//    @PostMapping("/account")
//    public String saveDay(@ModelAttribute("saveDay") Day day ){
//        dayService.saveDay(day);
//        return "redirect:/account";
//    }
//
//}
