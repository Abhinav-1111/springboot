package Week2.Assignment.annotations;

import Week2.Assignment.exception.ResourceNotFoundException;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PrimeNumberValidator implements ConstraintValidator<PrimeNumberValidation, Integer> {

    @Override
    public boolean isValid(Integer num, ConstraintValidatorContext constraintValidatorContext) {
        if (num == null){
            throw new ResourceNotFoundException("Null value is not allowed");
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
