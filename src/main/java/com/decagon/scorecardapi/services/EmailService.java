package com.decagon.scorecardapi.services;



public interface EmailService {


    boolean sendEmail(String body, String subject, String email);
}

