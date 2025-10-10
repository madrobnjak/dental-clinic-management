package md.practice.projects.dentalclinicmanagement.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PatientDataValidator implements ConstraintValidator<ValidPatientData, String> {

    private String jmbg;
    private String birthDate;

    @Override
    public void initialize(ValidPatientData constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return jmbg.substring(0, 8).equals(birthDate);
    }
}
