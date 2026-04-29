package org.example;

public class TeacherProfileProcessor implements AcademicProfileProcessor {

    @Override
    public boolean supports(String role) {
        return role.equals("teacher");
    }

    @Override
    public ProcessingResult process(AcademicProfileData data) {
        System.out.println("Creating teacher profile for: " + data.fullName);
        System.out.println("Assigning subject: " + data.subject);
        System.out.println("Assigning teacher to course: " + data.courseName);
        System.out.println("Assigning schedule: " + data.schedule);

        return new ProcessingResult(true, "Teacher profile created successfully");
    }
}
