package javarush.validation.jsr303;

import javarush.validation.AgeConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = AgeConstraintValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Age {

    String message() default "{Age}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
