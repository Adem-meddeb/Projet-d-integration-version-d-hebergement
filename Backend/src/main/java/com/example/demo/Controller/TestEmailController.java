package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.EmailService;

@RestController
@RequestMapping("/test")
public class TestEmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/sendEmail")
    public ResponseEntity<String> sendTestEmail() {
        try {
            emailService.sendEventRegistrationEmail("recipient@example.com", "Test Event");
            return ResponseEntity.ok("Email sent successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Failed to send email: " + e.getMessage());
        }
    }
}
