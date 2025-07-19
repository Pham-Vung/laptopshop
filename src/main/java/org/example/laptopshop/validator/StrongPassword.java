package org.example.laptopshop.validator;

import java.lang.annotation.*;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = StrongPasswordValidator.class) // đánh dấu để java biết đây là annotation để validate dữ liệu
@Target({ElementType.METHOD, ElementType.FIELD}) // phạm vi hoạt động của annatation
@Retention(RetentionPolicy.RUNTIME) // lúc runtime sẽ chạy annotation này
@Documented
public @interface StrongPassword {
    String message() default
            "Must be 8 characters long and combination of uppercase letters, numbers, special characters.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
