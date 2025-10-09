package md.practice.projects.dentalclinicmanagement.service;

import md.practice.projects.dentalclinicmanagement.entity.Patient;
import md.practice.projects.dentalclinicmanagement.exception.DuplicateResourceException;
import md.practice.projects.dentalclinicmanagement.exception.ResourceNotFoundException;
import md.practice.projects.dentalclinicmanagement.helper.PatientUpdateMapper;
import md.practice.projects.dentalclinicmanagement.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;
    private final PatientUpdateMapper patientUpdateMapper;

    public PatientService(PatientRepository patientRepository, PatientUpdateMapper patientUpdateMapper) {
        this.patientRepository = patientRepository;
        this.patientUpdateMapper = patientUpdateMapper;
    }

    public List<Patient> getAllProducts() {
        return patientRepository.findAll();
    }

    public Patient getPatientId(Long id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with id= " + id + " not found"));
    }

    public Patient createPatient(Patient patient) {
        if (!patientRepository.existsByEmail(patient.getEmail())) {
            return patientRepository.save(patient);
        } else {
            throw new DuplicateResourceException("Patient with name= " + patient.getEmail() + " already exists");
        }
    }

    public Patient updatePatient(Long id, Patient patientDetailsNew) {
        Patient existingPatient = getPatientId(id);
        Patient updatedPatient = patientUpdateMapper.updateMapper(existingPatient, patientDetailsNew);

        return patientRepository.save(updatedPatient);
    }

    public void deletePatientById(Long id) {
        getPatientId(id);
        patientRepository.deleteById(id);
    }

}
