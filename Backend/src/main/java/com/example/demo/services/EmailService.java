package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEventRegistrationEmail(String toEmail, String eventName) {
        // Create a simple email message
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail); // Recipient's email
        message.setSubject("Event Registration Confirmation"); // Email subject
        message.setText("Dear participant,\n\nYou have successfully registered for the event: " 
                        + eventName 
                        + ".\n\nThank you for your participation!\n\nBest regards,\nEvent Management Team");
        message.setFrom("meddebadem000@gmail.com"); // Sender's email
        mailSender.send(message); // Send the email
    }
}
