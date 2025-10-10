package md.practice.projects.dentalclinicmanagement.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {PatientDataValidator.class})
public @interface ValidPatientData {
    String message() default "Patient data is invalid";
    String jmbg();
    String birthDate();
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
