package abhik26.healthcare_management.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import abhik26.healthcare_management.entity.Patient;
import abhik26.healthcare_management.service.PatientService;


@RestController
@RequestMapping("/patients")
public class PatientRestController {

    final private PatientService patientService;

    public PatientRestController(PatientService patientService) {
        this.patientService = patientService;
    }
    
    @GetMapping("/{patientId}")
    public Patient getPatient(@PathVariable Long patientId) {
        return patientService.getPatient(patientId);
    }
    
}
