package org.example;

public class Main {

    public static void main(String[] args) {


        AcademicProfileService service = new AcademicProfileService();

        AcademiProfileData student = new AcademiProfileData(
            "student",
            "Laura Perez",
            "CC-123456",
            "laura.perez@school.com",
            16,
            "10th Grade",
            null,
            "Programming Basics",
            "Morning",
            4.9
        );

        AcademiProfileData teacher = new AcademiProfileData(
            "teacher",
            "Carlos Gomez",
            "CC-789012",
            "carlos.gomez@school.com",
            38,
            null,
            "Software Engineering",
            "Programming Basics",
            "Afternoon",
            4.7
        );

        System.out.println("\nRegister Student");
        service.registerProfile(student);

        System.out.println("\nRegister Teacher");
        service.registerProfile(teacher);
    }
}