package md.practice.projects.dentalclinicmanagement.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import md.practice.projects.dentalclinicmanagement.exception.InvalidBirthDateException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
@Service
public class BirthDateValidator implements ConstraintValidator<ValidBirthDate, String> {
    @Override
    public boolean isValid(String birthDate, ConstraintValidatorContext constraintValidatorContext) {
        int dd=Integer.parseInt(birthDate.substring(0,2));
        int mm=Integer.parseInt(birthDate.substring(2,4));
        int yyy=Integer.parseInt(birthDate.substring(4,7));

        int year=(yyy>=100)?(yyy+1000):(2000+yyy);
        try{
            LocalDate.of(year,mm,dd);
        }
        catch(InvalidBirthDateException e){
           throw new InvalidBirthDateException("Birth date is invalid");
        }
        return true;
    }
}
