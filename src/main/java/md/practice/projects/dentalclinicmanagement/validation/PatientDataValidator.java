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
        int year;
        if (yyy < 100) {
            year = 2000 + yyy;
        } else if (yyy >= 1000) {
            year = yyy;
        } else {
            year = 1000 + yyy;
        }

        int dd1 = Integer.parseInt(birthDate.substring(0, 2));
        int mm1 = Integer.parseInt(birthDate.substring(2, 4));
        int yyyy1 = Integer.parseInt(birthDate.substring(5));

        int year1;
        if (yyyy1 < 100) {
            year1 = 2000 + yyyy1;
        } else if (yyy >= 1000) {
            year1 = yyyy1;
        } else {
            year1 = 1000 + yyyy1;
        }

        LocalDate jmbgDate = LocalDate.of(year, mm, dd);
        LocalDate birthDateParsed = LocalDate.of(year1, mm1, dd1);

        return jmbgDate.equals(birthDateParsed);
    }
}
