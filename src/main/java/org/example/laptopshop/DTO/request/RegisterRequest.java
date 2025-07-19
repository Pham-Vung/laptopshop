package org.example.laptopshop.DTO.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

import org.example.laptopshop.validator.RegisterChecked;
import org.example.laptopshop.validator.StrongPassword;

import lombok.Getter;
import lombok.Setter;

@RegisterChecked
@Getter
@Setter
public class RegisterRequest {

    @Size(min = 4, message = "FirstName minimum 4 characters")
    private String firstName;

    private String lastName;

    @Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    private String email;

    @StrongPassword
    private String password;

    private String confirmPassword;
}
