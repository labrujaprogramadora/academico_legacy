package org.example;

public class TeacherRecognitionBenefit implements AcademicBenefitRule{
    @Override
    public boolean appliesTo(AcademicProfileData data) {
        return data.role.equals("teacher") && data.performanceScore >= 4.5;
    }

    @Override
    public void apply(AcademicProfileData data) {
        System.out.println("Benefit applied: public recognition for teacher performance");
    }
}
