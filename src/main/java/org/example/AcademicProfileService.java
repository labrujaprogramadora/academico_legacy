package org.example;

public class AcademicProfileService {

    private final DatabaseClient databaseClient = new DatabaseClient();
    private final EmailClient emailClient = new EmailClient();

    public void registerProfile(
            String role,
            String fullName,
            String documentNumber,
            String email,
            int age,
            String grade,
            String subject,
            String courseName,
            String schedule,
            double performanceScore
    ) {
        //
        if (role == null || role.isEmpty()) {
            System.out.println("Role is required");
            return;
        }

        if (fullName == null || fullName.isEmpty()) {
            System.out.println("Full name is required");
            return;
        }

        if (documentNumber == null || documentNumber.isEmpty()) {
            System.out.println("Document number is required");
            return;
        }

        if (email == null || !email.contains("@")) {
            System.out.println("Email is invalid");
            return;
        }

        if (age <= 0) {
            System.out.println("Age is invalid");
            return;
        }

        if (courseName == null || courseName.isEmpty()) {
            System.out.println("Course name is required");
            return;
        }

        //
        if (role.equals("student")) {

            if (grade == null || grade.isEmpty()) {
                System.out.println("Grade is required for students");
                return;
            }

            System.out.println("Creating student profile for: " + fullName);
            System.out.println("Assigning grade: " + grade);
            System.out.println("Enrolling student in course: " + courseName);
            System.out.println("Assigning schedule: " + schedule);

            if (performanceScore >= 4.8) {
                System.out.println("Benefit applied: free academic day for high performance student");
            }

        } else if (role.equals("teacher")) {

            if (subject == null || subject.isEmpty()) {
                System.out.println("Subject is required for teachers");
                return;
            }

            System.out.println("Creating teacher profile for: " + fullName);
            System.out.println("Assigning subject: " + subject);
            System.out.println("Assigning teacher to course: " + courseName);
            System.out.println("Assigning schedule: " + schedule);

            if (performanceScore >= 4.5) {
                System.out.println("Benefit applied: public recognition for teacher performance");
            }

        } else {
            System.out.println("Unsupported academic role");
            return;
        }

        //
        String dataToSave =
                "role=" + role +
                        ", fullName=" + fullName +
                        ", documentNumber=" + documentNumber +
                        ", email=" + email +
                        ", courseName=" + courseName +
                        ", schedule=" + schedule;

        databaseClient.save("academic_profiles", dataToSave);

        //
        emailClient.send(
                email,
                "Welcome to the academic platform",
                "Hello " + fullName + ", your academic profile was registered successfully."
        );
    }
}