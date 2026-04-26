package org.example;

public class AcademiNotificationService {
    private final EmailClient emailClient = new EmailClient();

    public void sendWelcomeMessage(AcademiProfileData data){
        emailClient.send(
                data.email,
                "Welcome to the academic platform",
                "Hello " + data.fullName + ", your academic profile was registered successfully."
        );
    }
}
