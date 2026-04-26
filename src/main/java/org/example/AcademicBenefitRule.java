package org.example;

public interface AcademicBenefitRule {
    boolean appliesTo(AcademicProfileData data);

    void apply(AcademicProfileData data);
}
