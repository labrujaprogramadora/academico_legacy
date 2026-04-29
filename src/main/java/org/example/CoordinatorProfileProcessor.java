package org.example;

public class CoordinatorProfileProcessor implements AcademicProfileProcessor {
    @Override
    public boolean supports(String role) {
        return role.equals("coordinator");
    }

    @Override
    public ProcessingResult process(AcademicProfileData data) {
        if(data.schedule == null || data.schedule.isEmpty()){
            return new ProcessingResult(false, "Schedule is required for coordinator profile");
        }

        System.out.println("Creating coordinator profile for: " + data.fullName);
        System.out.println("Coordinator assigned to course: " + data.courseName);
        System.out.println("Assigning schedule: " + data.schedule);

        return new ProcessingResult(true, "Coordinator profile created successfully");
    }
}
