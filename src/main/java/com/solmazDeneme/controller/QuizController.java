//package com.solmazDeneme.controller;
//
//
//import com.solmazDeneme.model.QuestionForm;
//import com.solmazDeneme.model.Result;
//import com.solmazDeneme.model.User;
//import com.solmazDeneme.repository.UserRepository;
//import com.solmazDeneme.service.QuestionService;
//import com.solmazDeneme.service.ResultService;
//import com.solmazDeneme.service.impl.EmailServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import java.security.Principal;
//import java.util.List;
//
//@Controller
//public class QuizController {
//    @Autowired
//    Result result;
//
//    @Autowired
//    QuestionService questionService;
//
//    @Autowired
//    ResultService resultService;
//
//    @Autowired
//    User user;
//
//    @Autowired
//    UserRepository userRepository;
//
//    @Autowired
//    EmailServiceImpl emailService;
//
//    Boolean submitted = false;
//
//    @ModelAttribute("result")
//    public Result getResult(){
//        return result;
//    }
//
//
//    @PostMapping("/quiz")
//    public String quiz(Model m, Principal principal, RedirectAttributes ra) {
//
//        submitted = false;
//
//        try{
//
//            if (principal.getName() == "admin") {
//
//                result.setUsername(principal.getName());
//
//                QuestionForm qForm = questionService.getQuestions();
//
//                m.addAttribute("qForm", qForm);
//
//                return "quiz";
//
//            } else {
//
//                User currentUser = userRepository.findByEmail(principal.getName());
//
//                if (!(currentUser.isCanEnterSurvey())) {
//
//                    ra.addFlashAttribute("warning", "You entered this survey before !!");
//                    return "redirect:/";
//
//                } else{
//
//                    result.setUsername(currentUser.getFirstName());
//
//                    result.setEmail(principal.getName());
//
//                    QuestionForm qForm = questionService.getQuestions();
//
//                    m.addAttribute("qForm", qForm);
//
//
//
//
//                    return "quiz";
//
//                }
//
//            }
//        }catch(Exception e){
//            return "login";
//        }
//    }
//
//
//
//
//
//    @PostMapping("/submit")
//    public String submit(@ModelAttribute QuestionForm qForm,String message,Principal principal) {
//
//        try{
//            User currentUser = userRepository.findByEmail(principal.getName());
//
//            if(!submitted) {
//
//                    result.setTotalCorrect(resultService.getResult(qForm));
//                    result.setSatisfaction(resultService.getResultSatisfaction(qForm));
//                    result.setMessage(resultService.getMessage(qForm));
//
//                    result.setMessage(message);
//
//                    resultService.saveScore(result);
//
//
//                    // Email Gönderme İşlemi
//                    emailService.sendEmail(principal);
//
//                    if(principal.getName() == "admin"){
//
//                        submitted = true;
//                        return "result";
//
//                    }else{
//
//                        // İknci girişi engelleme
//                        currentUser.setCanEnterSurvey(false);
//                        userRepository.save(currentUser);
//
//                        submitted = true;
//                        return "result";
//                    }
//
//
//            }
//            return "result";
//
//        }catch(Exception e){
//            return "login";
//        }
//    }
//
//    @GetMapping("/score")
//    public String score(Model m) {
//        List<Result> sList = resultService.getTopScore();
//
//        m.addAttribute("sList", sList);
//
//        return "scoreboard";
//    }
//
//
//}
