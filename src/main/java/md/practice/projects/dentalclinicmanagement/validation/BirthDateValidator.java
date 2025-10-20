package md.practice.projects.dentalclinicmanagement.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import md.practice.projects.dentalclinicmanagement.helper.ConvertDataTypes;

import java.time.DateTimeException;
public class BirthDateValidator implements ConstraintValidator<ValidBirthDate, String> {

    private final ConvertDataTypes convertDataTypes;

    public BirthDateValidator(ConvertDataTypes convertDataTypes) {
        this.convertDataTypes = convertDataTypes;
    }

    @Override
    public boolean isValid(String birthDate, ConstraintValidatorContext constraintValidatorContext) {
        try{
            convertDataTypes.toLocalDate(birthDate);
        }
        catch(DateTimeException e){
           return false;
        }
        return true;
    }
}
