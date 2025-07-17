package org.example.laptopshop.DTO.request;

import lombok.Getter;
import lombok.Setter;
import org.example.laptopshop.validator.RegisterChecked;
import org.example.laptopshop.validator.StrongPassword;

@RegisterChecked
@Getter
@Setter
public class RegisterRequest {
    private String firstName;
    private String lastName;
    private String email;

    @StrongPassword
    private String password;
    private String confirmPassword;
}
