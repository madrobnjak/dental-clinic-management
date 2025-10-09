package md.practice.projects.dentalclinicmanagement.mapper;

import md.practice.projects.dentalclinicmanagement.dto.PatientDTO;
import md.practice.projects.dentalclinicmanagement.entity.Patient;
import org.springframework.stereotype.Service;

@Service
public class PatientEntityMapper {
    public Patient mappPatientDTOToPatient(PatientDTO patientDTO) {
        Patient patient = new Patient();
        patient.setFirstName(patientDTO.firstName());
        patient.setLastName(patientDTO.lastName());
        patient.setDateOfBirth(patientDTO.dateOfBirth());
        patient.setPhone(patientDTO.phone());
        patient.setEmail(patientDTO.email());
        patient.setAddress(patientDTO.address());
        patient.setMedicalHistory(patientDTO.medicalHistory());
        return patient;
    }
}
