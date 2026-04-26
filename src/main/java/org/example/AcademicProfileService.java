package org.example;

public class AcademicProfileService {

    private final AcademicProfileValidator validator = new AcademicProfileValidator();
    private final AcademicProfileRepository repository = new AcademicProfileRepository();
    private final EmailClient emailClient = new EmailClient();
    private final AcademicNotificationService notificationService = new AcademicNotificationService();

    public void registerProfile(AcademicProfileData data) {
        // Validación de datos
        if(!validator.validate(data)){
            return;
        }

        // Asignación de atributos por rol
        if (data.role.equals("student")) {

            System.out.println("Creating student profile for: " + data.fullName);
            System.out.println("Assigning grade: " + data.grade);
            System.out.println("Enrolling student in course: " + data.courseName);
            System.out.println("Assigning schedule: " + data.schedule);

        } else if (data.role.equals("teacher")) {

            System.out.println("Creating teacher profile for: " + data.fullName);
            System.out.println("Assigning subject: " + data.subject);
            System.out.println("Assigning teacher to course: " + data.courseName);
            System.out.println("Assigning schedule: " + data.schedule);

        } else {
            System.out.println("Unsupported academic role");
            return;
        }

        // Guardar en base de datos
        repository.save(data);

        // Enviar notificación
        notificationService.sendWelcomeMessage(data);

    }
}