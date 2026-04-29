package org.example;

public interface AcademicProfileProcessor {
    boolean supports(String role);
    ProcessingResult process(AcademicProfileData data);
}
