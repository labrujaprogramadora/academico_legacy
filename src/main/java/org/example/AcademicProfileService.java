package org.example;

public class AcademicProfileService {

    private final AcademiProfileValidator validator = new AcademiProfileValidator();
    private final AcademiProfileRepository repository = new AcademiProfileRepository();
    private final EmailClient emailClient = new EmailClient();

    public void registerProfile(AcademiProfileData data) {
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

            if (data.performanceScore >= 4.8) {
                System.out.println("Benefit applied: free academic day for high performance student");
            }

        } else if (data.role.equals("teacher")) {


            System.out.println("Creating teacher profile for: " + data.fullName);
            System.out.println("Assigning subject: " + data.subject);
            System.out.println("Assigning teacher to course: " + data.courseName);
            System.out.println("Assigning schedule: " + data.schedule);

            if (data.performanceScore >= 4.5) {
                System.out.println("Benefit applied: public recognition for teacher performance");
            }

        } else {
            System.out.println("Unsupported academic role");
            return;
        }

        // Guardar en base de datos
        repository.save(data);

        // Enviar notificación
        emailClient.send(
                data.email,
                "Welcome to the academic platform",
                "Hello " + data.fullName + ", your academic profile was registered successfully."
        );
    }
}