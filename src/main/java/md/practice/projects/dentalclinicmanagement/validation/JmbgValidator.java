package md.practice.projects.dentalclinicmanagement.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Service;

@Service
public class JmbgValidator implements ConstraintValidator<ValidJmbg, String> {
    private final BirthDateValidator  birthDateValidator;

    public JmbgValidator(BirthDateValidator birthDateValidator) {
        this.birthDateValidator = birthDateValidator;
    }

    @Override
    public boolean isValid(String jmbg, ConstraintValidatorContext constraintValidatorContext) {
        boolean isValid = false;

        if(jmbg == null || jmbg.length() < 13){
            return isValid;
        }
        int[] digits=jmbg.chars().map(c->c-'0').toArray();

        String birthDate=jmbg.substring(0,8);
        birthDateValidator.isValid(birthDate,constraintValidatorContext);

        int sum = 7 * (digits[0] + digits[6])
                + 6 * (digits[1] + digits[7])
                + 5 * (digits[2] + digits[8])
                + 4 * (digits[3] + digits[9])
                + 3 * (digits[4] + digits[10])
                + 2 * (digits[5] + digits[11]);

        int mod = sum % 11;
        int m = 11 - mod;
        int control = (m == 10 || m == 11) ? 0 : m;

        return digits[12] == control;
    }
}
