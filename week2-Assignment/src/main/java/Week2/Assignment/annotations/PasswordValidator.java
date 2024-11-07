package Week2.Assignment.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<PasswordValidation, String> {

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        if (password == null || password.length() < 10){
            return false;
        }
//        else{
//            boolean check= isValidPassword(password);
//            return check;
//        }
        return isValidPassword(password);
    }

    private boolean isValidPassword(String password) {
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasSpecialChar = false;
        String specialChar = "!@#$%^&*()-+";

        // check for minimum length
//        if (password.length() < 10) return false;

        // Iterate through the password character
        for (char c : password.toCharArray()){
            if (Character.isUpperCase(c)){
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (specialChar.indexOf(c) >= 0) {
                hasSpecialChar = true;
            }
        }

        // If all conditions are met, return true e
        if (hasUpperCase && hasLowerCase && hasSpecialChar){
            return true;
        }

        return false;
    }
}
