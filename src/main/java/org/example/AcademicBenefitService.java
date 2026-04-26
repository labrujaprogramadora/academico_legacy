package org.example;

public class AcademicBenefitService {
    private AcademicBenefitRule[] rules = {
            new StudentFreeDayBenefitRule(),
            new TeacherRecognitionBenefit()
    };


    public void applyBenefit(AcademicProfileData data){
       for (AcademicBenefitRule rule : rules) {
           if(rule.appliesTo(data)){
               rule.apply(data);
           }
       }
    }
}
