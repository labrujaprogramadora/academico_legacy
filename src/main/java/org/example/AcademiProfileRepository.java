package org.example;

public class AcademiProfileRepository {
    private final DatabaseClient databaseClient = new DatabaseClient();

    public void save(AcademiProfileData data){
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
