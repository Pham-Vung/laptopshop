package org.example.laptopshop.controller.admin;

import java.util.List;

import jakarta.validation.Valid;

import org.example.laptopshop.entity.User;
import org.example.laptopshop.service.interfaces.IUploadService;
import org.example.laptopshop.service.interfaces.IUserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/user")
public class UserController {
    private final IUserService userService;
    private final IUploadService uploadService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String getHomePage(Model model) {
        List<User> users = userService.getAllUsersByEmail("user2@gmail.com");

        model.addAttribute("vincent", "test");
        return "hello";
    }

    @GetMapping
    public String getUserPage(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "admin/user/show";
    }

    @GetMapping("/create")
    public String getCreateUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    @PostMapping("/create")
    public String createUserPage(
            @Valid @ModelAttribute("newUser") User user,
            BindingResult newUserBindingResult,
            @RequestParam("vincentFile") MultipartFile file) {

        List<FieldError> errors = newUserBindingResult.getFieldErrors();
        for (FieldError error : errors) {
            System.out.println(error.getField() + "-" + error.getDefaultMessage());
        }

        if (newUserBindingResult.hasErrors()) {
            return "admin/user/create";
        }

        String avatar = uploadService.handleSaveUploadFile(file, "avatar");

        String hashPassword = passwordEncoder.encode(user.getPassword());

        user.setPassword(hashPassword);
        user.setAvatar(avatar);
        user.setRole(userService.getRoleByName(user.getRole().getName()));

        userService.handleSaveUser(user);

        return "redirect:/admin/user";
    }

    @GetMapping("/{id}")
    public String getUserDetailPage(Model model, @PathVariable long id) {
        model.addAttribute("id", id);
        model.addAttribute("user", userService.getUserById(id));
        return "admin/user/detail";
    }

    @GetMapping("/update/{id}")
    public String getUpdateUserPage(Model model, @PathVariable long id) {
        User currentUser = userService.getUserById(id);
        model.addAttribute("newUser", currentUser);
        return "admin/user/update";
    }

    @PostMapping("/update")
    public String postUpdateUser(@ModelAttribute("newUser") User user) {
        User currentUser = userService.getUserById(user.getId());

        if (currentUser != null) {
            currentUser.setPhone(user.getPhone());
            currentUser.setFullName(user.getFullName());
            currentUser.setAddress(user.getAddress());

            userService.handleSaveUser(currentUser);
        }

        return "redirect:/admin/user";
    }

    @GetMapping("/delete/{id}")
    public String getDeleteUserPage(Model model, @PathVariable long id) {
        model.addAttribute("id", id);
        model.addAttribute("newUser", new User());
        return "admin/user/delete";
    }

    @PostMapping("/delete")
    public String postDeleteUser(@ModelAttribute("newUser") User user) {
        userService.deleteUserById(user.getId());
        return "redirect:/admin/user";
    }
}
