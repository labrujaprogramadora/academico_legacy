package org.example;

public class StudentAcademicOperations implements StudentOperationsService{

    @Override
    public void enrollStudentInCourse(AcademicProfileData data) {
        System.out.println("Student enrolled in course" + data.courseName);
    }
}
