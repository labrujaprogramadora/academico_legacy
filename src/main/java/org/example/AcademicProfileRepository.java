package org.example;

public class AcademicProfileRepository {
    private final DatabaseClient databaseClient = new DatabaseClient();

    public void save(AcademicProfileData data){
        String dataToSave =
                "role=" + data.role +
                ", fullName=" + data.fullName +
                ", documentNumber=" + data.documentNumber +
                ", email=" + data.email +
                ", courseName=" + data.courseName +
                ", schedule=" + data.schedule;

        databaseClient.save("academic_profiles", dataToSave);
    }
}
