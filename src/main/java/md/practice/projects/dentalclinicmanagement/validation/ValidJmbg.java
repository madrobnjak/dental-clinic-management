package md.practice.projects.dentalclinicmanagement.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = JmbgValidator.class)
public @interface ValidJmbg {
    String message() default "Invalid JMBG number";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
