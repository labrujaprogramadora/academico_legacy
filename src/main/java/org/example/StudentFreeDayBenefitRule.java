package org.example;

public class StudentFreeDayBenefitRule implements AcademicBenefitRule{
    @Override
    public boolean appliesTo(AcademicProfileData data) {
        return data.role.equals("student") && data.performanceScore >= 4.8;
    }

    @Override
    public void apply(AcademicProfileData data) {
        System.out.println("Benefit applied: free academic day for high performance student");
    }
}
