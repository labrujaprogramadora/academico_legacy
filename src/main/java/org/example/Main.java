package org.example;

public class Main {

    public static void main(String[] args) {


        AcademicProfileService service = new AcademicProfileService();

        AcademicProfileData student = new AcademicProfileData(
            "student",
            "Laura Perez",
            "CC-123456",
            "laura.perez@school.com",
            16,
            "10th Grade",
            null,
            null,
            "Morning",
            4.9
        );

        AcademicProfileData teacher = new AcademicProfileData(
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

        AcademicProfileData coordinator = new AcademicProfileData(
                "coordinator",
                "Marta Lopez",
                "CC-999999",
                "marta.lopez@school.com",
                45,
                null,
                null,
                "Software Engineering",
                null,
                4.6
        );

        System.out.println("\nRegister Student");
        service.registerProfile(student);

        System.out.println("\nRegister Teacher");
        service.registerProfile(teacher);

        System.out.println("\nRegister Coordinator");
        service.registerProfile(coordinator);
    }
}