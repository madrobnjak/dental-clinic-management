package md.practice.projects.dentalclinicmanagement.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class PhoneValidator implements ConstraintValidator<ValidPhone, String> {

    private static final Pattern PHONE_PATTERN = Pattern.compile(
            "^(\\+381[\\s\\-]?|0)6[0-9][\\s\\-]?[0-9]{3}[\\s\\-]?[0-9]{3,4}$"
    );

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null || value.isBlank()) {
            return true;
        }

        return PHONE_PATTERN.matcher(value).matches();
    }
}
