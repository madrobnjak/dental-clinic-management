package md.practice.projects.dentalclinicmanagement.mapper;

import md.practice.projects.dentalclinicmanagement.dto.PatientDTO;
import md.practice.projects.dentalclinicmanagement.entity.Patient;
import org.springframework.stereotype.Service;

@Service
public class EntityMapper {
    public Patient mappDTOtoEntity(PatientDTO patientDTO) {
        Patient patient = new Patient();
        patient.setFirstName(patientDTO.firstName());
        patient.setLastName(patientDTO.lastName());
        patient.setDateOfBirth(patientDTO.dateOfBirth());
        patient.setJmbg(patientDTO.jmbg());
        patient.setPhone(patientDTO.phone());
        patient.setEmail(patientDTO.email());
        patient.setAddress(patientDTO.address());
        patient.setMedicalHistory(patientDTO.medicalHistory());
        return patient;
    }
}
