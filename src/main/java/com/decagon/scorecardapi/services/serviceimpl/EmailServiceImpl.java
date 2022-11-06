package com.decagon.scorecardapi.services.serviceimpl;

import com.decagon.scorecardapi.services.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;
    @Value("${sender.email:email}")
    private String sender;



    @Override
    public boolean sendEmail(String body, String subject, String email) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(sender);
            message.setTo(email);
            message.setText(body);
            message.setSubject(subject);
            mailSender.send(message);
            log.info("Email sent to %s successfully". formatted(email));
            return true;
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            return false;
        }
    }
}
