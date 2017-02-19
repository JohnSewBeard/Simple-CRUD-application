package javarush.validation;

import javarush.validation.jsr303.Age;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeConstraintValidator implements ConstraintValidator<Age, Integer> {

    @Override
    public void initialize(Age age) {
    }

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        return integer != null && integer > 18 && integer < 100;
    }
}
