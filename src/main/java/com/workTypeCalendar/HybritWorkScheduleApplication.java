package com.workTypeCalendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HybritWorkScheduleApplication {

    public static void main(String[] args) {
        SpringApplication.run(HybritWorkScheduleApplication.class, args);
    }

}
//*******************************************
//package com.solmazDeneme;
//
//import com.solmazDeneme.model.Day;
//import com.solmazDeneme.model.Role;
//import com.solmazDeneme.model.User;
//import com.solmazDeneme.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//import java.util.Arrays;
//
//@SpringBootApplication
//public class HybritWorkScheduleApplication implements CommandLineRunner {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    public static void main(String[] args) {
//        SpringApplication.run(HybritWorkScheduleApplication.class, args);
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        User user = new User("Hüseyin", "Gürel", "h@gmail.com", "1234",true, Arrays.asList(new Role("ROLE_USER")));
//
//        Day day1 = new Day("remote");
//        Day day2 = new Day("hybrid");
//
//        user.getDays().add(day1);
//        user.getDays().add(day2);
//
//        day1.getUsers().add(user);
//        day2.getUsers().add(user);
//
//        this.userRepository.save(user);
//
//    }
//}