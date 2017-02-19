package javarush.validation;

import javarush.validation.jsr303.Name;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NameConstraintValidator implements ConstraintValidator<Name, String> {
    @Override
    public void initialize(Name name) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s != null && s.length() > 1 && s.length() < 26;
    }
}
