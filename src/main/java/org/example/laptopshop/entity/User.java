package org.example.laptopshop.entity;

import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    @NotEmpty(message = "Email cannot be empty")
    private String email;

    @NotNull
    @Size(min = 6, message = "Password minimum 6 characters")
    private String password;

    @NotNull
    @Size(min = 4, message = "FullName minimum 4 characters")
    private String fullName;

    private String address;
    private String phone;
    private String avatar;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    @Override
    public String toString() {
        return "User{" + "id="
                + id + ", email='"
                + email + '\'' + ", password='"
                + password + '\'' + ", fullName='"
                + fullName + '\'' + ", address='"
                + address + '\'' + ", phone='"
                + phone + '\'' + ", avatar='"
                + avatar + '\'' + '}';
    }
}
