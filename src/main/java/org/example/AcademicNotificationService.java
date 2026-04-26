package org.example;

public class AcademicNotificationService {
    private final EmailClient emailClient = new EmailClient();

    public void sendWelcomeMessage(AcademicProfileData data){
        emailClient.send(
                data.email,
                "Welcome to the academic platform",
                "Hello " + data.fullName + ", your academic profile was registered successfully."
        );
    }
}
