package org.example.laptopshop.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import org.example.laptopshop.DTO.request.RegisterRequest;
import org.example.laptopshop.service.interfaces.IUserService;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegisterValidator implements ConstraintValidator<RegisterChecked, RegisterRequest> {
    private final IUserService userService;

    @Override
    public boolean isValid(RegisterRequest request, ConstraintValidatorContext context) {
        boolean isValid = true;

        if (!request.getPassword().equals(request.getConfirmPassword())) {
            context.buildConstraintViolationWithTemplate("Invalid confirmation password")
                    .addPropertyNode("confirmPassword")
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();

            isValid = false;
        }

        if (userService.isEmailExist(request.getEmail())) {
            context.buildConstraintViolationWithTemplate("Email existed")
                    .addPropertyNode("email")
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();

            isValid = false;
        }

        return isValid;
    }
}
