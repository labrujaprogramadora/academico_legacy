package org.example;

public class AcademicProfileService {

    private final DatabaseClient databaseClient = new DatabaseClient();
    private final EmailClient emailClient = new EmailClient();

    public void registerProfile(AcademiProfileData data) {
        // Validación de datos
        if (data.role == null || data.role.isEmpty()) {
            System.out.println("Role is required");
            return;
        }

        if (data.fullName == null || data.fullName.isEmpty()) {
            System.out.println("Full name is required");
            return;
        }

        if (data.documentNumber == null || data.documentNumber.isEmpty()) {
            System.out.println("Document number is required");
            return;
        }

        if (data.email == null || !data.email.contains("@")) {
            System.out.println("Email is invalid");
            return;
        }

        if (data.age <= 0) {
            System.out.println("Age is invalid");
            return;
        }

        if (data.courseName == null || data.courseName.isEmpty()) {
            System.out.println("Course name is required");
            return;
        }

        // Asignación de atributos por rol
        if (data.role.equals("student")) {

            if (data.grade == null || data.grade.isEmpty()) {
                System.out.println("Grade is required for students");
                return;
            }

            System.out.println("Creating student profile for: " + data.fullName);
            System.out.println("Assigning grade: " + data.grade);
            System.out.println("Enrolling student in course: " + data.courseName);
            System.out.println("Assigning schedule: " + data.schedule);

            if (data.performanceScore >= 4.8) {
                System.out.println("Benefit applied: free academic day for high performance student");
            }

        } else if (data.role.equals("teacher")) {

            if (data.subject == null || data.subject.isEmpty()) {
                System.out.println("Subject is required for teachers");
                return;
            }

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
        String dataToSave =
                "role=" + data.role +
                        ", fullName=" + data.fullName +
                        ", documentNumber=" + data.documentNumber +
                        ", email=" + data.email +
                        ", courseName=" + data.courseName +
                        ", schedule=" + data.schedule;

        databaseClient.save("academic_profiles", dataToSave);

        // Enviar notificación
        emailClient.send(
                data.email,
                "Welcome to the academic platform",
                "Hello " + data.fullName + ", your academic profile was registered successfully."
        );
    }
}