package md.practice.projects.dentalclinicmanagement.mapper;

import md.practice.projects.dentalclinicmanagement.dto.PatientDTO;
import md.practice.projects.dentalclinicmanagement.dto.PatientSearchDTO;
import md.practice.projects.dentalclinicmanagement.entity.Patient;
import md.practice.projects.dentalclinicmanagement.helper.ConvertDataTypes;
import md.practice.projects.dentalclinicmanagement.helper.NormalizeEmail;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class EntityMapper {
    private final NormalizeEmail normalizeEmail;
    private final ConvertDataTypes convertDataTypes;

    public EntityMapper(NormalizeEmail normalizeEmail, ConvertDataTypes convertDataTypes) {
        this.normalizeEmail = normalizeEmail;
        this.convertDataTypes = convertDataTypes;
    }

    public Patient mappDTOtoEntity(PatientDTO patientDTO) {

        LocalDate dateOfBirth = convertDataTypes.toLocalDate(patientDTO.dateOfBirth());
        Long jmbg = convertDataTypes.toLong(patientDTO.jmbg());

        Patient patient = new Patient();
        patient.setFirstName(patientDTO.firstName());
        patient.setLastName(patientDTO.lastName());
        patient.setDateOfBirth(dateOfBirth);
        patient.setJmbg(jmbg);
        patient.setPhone(patientDTO.phone());
        if (patientDTO.email() != null) {
            String normalizedEmail = normalizeEmail.doNormalize(patientDTO.email());
            patient.setEmail(normalizedEmail);
        }
        patient.setAddress(patientDTO.address());
        patient.setMedicalHistory(patientDTO.medicalHistory());
        return patient;
    }

    public Patient mappDTOtoEntity(PatientSearchDTO searchDTO) {
        Patient patient = new Patient();
        if (searchDTO.jmbg() != null) {
            Long jmbg = convertDataTypes.toLong(searchDTO.jmbg());
            patient.setJmbg(jmbg);

        }
        patient.setFirstName(searchDTO.firstName());
        patient.setLastName(searchDTO.lastName());
        patient.setPhone(searchDTO.phone());
        return patient;
    }
}
