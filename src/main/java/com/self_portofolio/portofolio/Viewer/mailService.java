package com.self_portofolio.portofolio.Viewer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class mailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendViewerEmail(String name, String email, String message) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo("your_email@gmail.com"); // Recipient
        mail.setSubject("New Viewer Submission from Portfolio");
        mail.setText("Name: " + name + "\nEmail: " + email + "\nMessage: " + message);
        mailSender.send(mail);
    }
}

