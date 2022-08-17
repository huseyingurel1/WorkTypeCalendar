package com.solmazDeneme.service;

import java.security.Principal;

public interface EmailService {

    public String sendEmail(Principal principal);

}
