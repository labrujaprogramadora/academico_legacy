package org.example;

public class AcademicProfileValidator {
    public boolean validate(AcademicProfileData data) {
        if (data.role == null || data.role.isEmpty()) {
            System.out.println("Role is required");
            return false;
        }

        if (data.fullName == null || data.fullName.isEmpty()) {
            System.out.println("Full name is required");
            return false;
        }

        if (data.documentNumber == null || data.documentNumber.isEmpty()) {
            System.out.println("Document number is required");
            return false;
        }

        if (data.email == null || !data.email.contains("@")) {
            System.out.println("Email is invalid");
            return false;
        }

        if (data.age <= 0) {
            System.out.println("Age is invalid");
            return false;
        }

        if (data.courseName == null || data.courseName.isEmpty()) {
            System.out.println("Course name is required");
            return false;
        }

        return true;
    }
}
