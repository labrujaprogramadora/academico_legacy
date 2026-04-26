package org.example;

public class AcademicBenefitService {
    public void applyBenefit(AcademicProfileData data){
        if (data.role.equals("student") && data.performanceScore >= 4.8) {
            System.out.println("Benefit applied: free academic day for high performance student");
        }

        if (data.role.equals("teacher") && data.performanceScore >= 4.5) {
            System.out.println("Benefit applied: public recognition for teacher performance");
        }

    }
}
