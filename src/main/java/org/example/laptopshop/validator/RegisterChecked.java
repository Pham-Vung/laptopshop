package org.example.laptopshop.validator;

import java.lang.annotation.*;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = RegisterValidator.class)
@Target({ElementType.TYPE}) // Adjusted to apply to the class level
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RegisterChecked {
    String message() default "User register validation failed";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
