package org.example;

public class AcademicProfileData {
    public String role;
    public String fullName;
    public String documentNumber;
    public String email;
    public int age;
    public String grade;
    public String subject;
    public String courseName;
    public String schedule;
    public double performanceScore;

    public AcademicProfileData(
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
        this.role = role;
        this.fullName = fullName;
        this.documentNumber = documentNumber;
        this.email = email;
        this.age = age;
        this.grade = grade;
        this.subject = subject;
        this.courseName = courseName;
        this.schedule = schedule;
        this.performanceScore = performanceScore;
    }
}
