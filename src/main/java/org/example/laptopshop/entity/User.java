package org.example.laptopshop.entity;

import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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

    @NotNull
    @Email
    private String email;

    @NotNull
    @Size(min = 3)
    private String password;

    @NotNull
    @Size(min = 2)
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
