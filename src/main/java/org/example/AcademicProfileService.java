package org.example;

public class AcademicProfileService {

    private AcademicProfileValidator validator;
    private AcademicProfileRepository repository;
    private AcademicNotificationService notificationService;
    private AcademicProfileProcessor[] processors;

    public AcademicProfileService(
            AcademicProfileValidator validator,
            AcademicProfileRepository repository,
            AcademicNotificationService notificationService,
            AcademicProfileProcessor[] processors
    ) {
        this.validator = validator;
        this.repository = repository;
        this.notificationService = notificationService;
        this.processors = processors;
    }

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

        ProcessingResult result = selectedProcessor.process(data);

        if (!result.success) {
            System.out.println(result.message);
            return;
        }

        selectedProcessor.process(data);
        

        // Guardar en base de datos
        repository.save(data);

        // Enviar notificación
        notificationService.sendWelcomeMessage(data);

    }
}














