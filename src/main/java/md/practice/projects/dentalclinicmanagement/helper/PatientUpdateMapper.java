package md.practice.projects.dentalclinicmanagement.helper;

import md.practice.projects.dentalclinicmanagement.entity.Patient;
import org.springframework.stereotype.Component;

@Component
public class PatientUpdateMapper {
    public Patient updateMapper(Patient existingPatient, Patient patientDetailsNew) {
        existingPatient.setFirstName(patientDetailsNew.getFirstName());
        existingPatient.setLastName(patientDetailsNew.getLastName());
        existingPatient.setDateOfBirth(patientDetailsNew.getDateOfBirth());
        existingPatient.setPhone(patientDetailsNew.getPhone());
        existingPatient.setEmail(patientDetailsNew.getEmail());
        existingPatient.setAddress(patientDetailsNew.getAddress());
        existingPatient.setMedicalHistory(patientDetailsNew.getMedicalHistory());
        return existingPatient;
    }
}
