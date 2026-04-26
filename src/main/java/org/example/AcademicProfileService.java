package org.example;

public class AcademicProfileService {

    private final AcademicProfileValidator validator = new AcademicProfileValidator();
    private final AcademicProfileRepository repository = new AcademicProfileRepository();
    private final AcademicNotificationService notificationService = new AcademicNotificationService();

    private final AcademicProfileProcessor[] processors ={
            new StudentProfileProcessor(),
            new TeacherProfileProcessor()
    };

    public void registerProfile(AcademicProfileData data) {
        // Validación de datos
        if(!validator.validate(data)){
            return;
        }

        // Asignación de atributos por rol
        AcademicProfileProcessor selectedProcessor = null;
        for(AcademicProfileProcessor processor : processors){
            if(processor.supports(data.role)){
                selectedProcessor = processor;
                break;
            }
        }
        if(selectedProcessor == null){
            System.out.println("Unsupported academic role");
            return;
        }

        selectedProcessor.process(data);
        

        // Guardar en base de datos
        repository.save(data);

        // Enviar notificación
        notificationService.sendWelcomeMessage(data);

    }
}