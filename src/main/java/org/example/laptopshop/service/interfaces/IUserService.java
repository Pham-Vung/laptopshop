package org.example.laptopshop.service.interfaces;

import org.example.laptopshop.entity.Role;
import org.example.laptopshop.entity.User;

import java.util.List;

public interface IUserService {
    User handleSaveUser(User user);

    List<User> getAllUsers();

    List<User> getAllUsersByEmail(String email);

    User getUserById(long id);

    void deleteUserById(long id);

    Role getRoleByName(String roleName);

    boolean isEmailExist(String email);
}
