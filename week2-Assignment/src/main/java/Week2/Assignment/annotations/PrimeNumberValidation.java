package Week2.Assignment.annotations;

import jakarta.persistence.Table;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER} )
//@Constraint(validatedBy = {PrimeNumberValidator.class})
@Constraint(validatedBy = {PrimeNumberValidator.class})
public @interface PrimeNumberValidation {
    String message() default "Number should be a prime Number";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
