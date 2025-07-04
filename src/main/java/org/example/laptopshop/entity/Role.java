package org.example.laptopshop.entity;

import java.util.List;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String description;

    @OneToMany(mappedBy = "role")
    private List<User> users;

    @Override
    public String toString() {
        return "Role{" + "id=" + id + ", name='" + name + '\'' + ", description='" + description + '\'' + '}';
    }
}
