package abhik26.healthcare_management.service;

import org.springframework.stereotype.Service;

import abhik26.healthcare_management.entity.Patient;
import abhik26.healthcare_management.repository.PatientRepository;


@Service
public class PatientServiceImpl implements PatientService {

    final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
    
    @Override
    public Patient getPatient(Long patientId) {

        Patient patient = patientRepository.getById(patientId);

        return patient;
    }
}
