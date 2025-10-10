package md.practice.projects.dentalclinicmanagement.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import md.practice.projects.dentalclinicmanagement.dto.PatientDTO;

import java.time.LocalDate;

public class PatientDataValidator implements ConstraintValidator<ValidPatientData, PatientDTO> {

    @Override
    public boolean isValid(PatientDTO dto, ConstraintValidatorContext constraintValidatorContext) {
        String jmbg = dto.jmbg();
        String birthDate = dto.dateOfBirth();

        int dd = Integer.parseInt(jmbg.substring(0, 2));
        int mm = Integer.parseInt(jmbg.substring(2, 4));
        int yyy = Integer.parseInt(jmbg.substring(4, 7));
        int year = (yyy >= 100) ? (yyy + 1000) : (2000 + yyy);

        int dd1 = Integer.parseInt(birthDate.substring(0, 2));
        int mm1 = Integer.parseInt(birthDate.substring(2, 4));
        int yyyy1 = Integer.parseInt(birthDate.substring(4));

        LocalDate jmbgDate = LocalDate.of(year, mm, dd);
        LocalDate birthDateParsed = LocalDate.of(yyyy1, mm1, dd1);

        return jmbgDate.equals(birthDateParsed);
    }
}
