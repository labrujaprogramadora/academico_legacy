package org.example;

public class StudentProfileProcessor implements AcademicProfileProcessor{
    @Override
    public boolean supports(String role) {
        return role.equals("student");
    }

    @Override
    public void process(AcademicProfileData data) {
        System.out.println("Creating student profile for: " + data.fullName);
        System.out.println("Assigning grade: " + data.grade);
        System.out.println("Enrolling student in course: " + data.courseName);
        System.out.println("Assigning schedule: " + data.schedule);
    }
}
