package org.example;

public class EmailClient {

    public void send(String email, String subject, String message) {
        System.out.println("Sending email to " + email);
        System.out.println("Subject: " + subject);
        System.out.println("Message: " + message);
    }
}