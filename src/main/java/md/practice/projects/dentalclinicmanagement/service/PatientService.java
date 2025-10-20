package md.practice.projects.dentalclinicmanagement.service;

import md.practice.projects.dentalclinicmanagement.entity.Patient;
import md.practice.projects.dentalclinicmanagement.exception.DuplicateResourceException;
import md.practice.projects.dentalclinicmanagement.repository.PatientRepository;

import md.practice.projects.dentalclinicmanagement.specification.PatientSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient createPatient(Patient patient) {
        if (!patientRepository.existsByJmbg(patient.getJmbg())) {
            return patientRepository.save(patient);
        } else {
            throw new DuplicateResourceException("Patient with jmbg= " + patient.getJmbg() + " already exists");
        }
    }

    public List<Patient> searchPatients(Patient patient) {
        Specification<Patient> spec = PatientSpecification.hasEmail(patient.getEmail())
                .and(PatientSpecification.hasJmbg(patient.getJmbg()))
                .and(PatientSpecification.hasPhone(patient.getPhone()))
                .and(PatientSpecification.firstNameContains(patient.getFirstName()))
                .and(PatientSpecification.lastNameContains(patient.getLastName()));

        return patientRepository.findAll(spec);
    }

}
