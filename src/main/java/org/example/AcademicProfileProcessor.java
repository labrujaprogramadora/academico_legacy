package org.example;

public interface AcademicProfileProcessor {
    boolean supports(String role);
    void process(AcademicProfileData data);
}
