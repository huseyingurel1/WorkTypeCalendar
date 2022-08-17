package com.solmazDeneme.service;


import com.solmazDeneme.dto.UserRegistrationDto;
import com.solmazDeneme.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface IUserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);

    List<User> getAllUsers();

//    User addDayPlan(User user);

    User getUserById(Long id);
    User getUserByEmail(String Email);

    User updateUser(User user);



}
