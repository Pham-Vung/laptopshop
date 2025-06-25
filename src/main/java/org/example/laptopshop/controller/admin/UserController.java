package org.example.laptopshop.controller.admin;

import lombok.RequiredArgsConstructor;
import org.example.laptopshop.entity.User;
import org.example.laptopshop.service.interfaces.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/user")
public class UserController {
    private final IUserService userService;

    @GetMapping("/")
    public String getHomePage(Model model) {
        List<User> users = userService.getAllUsersByEmail("user2@gmail.com");
        System.out.println(users);

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
    public String createUserPage(@ModelAttribute("newUser") User user, Model model) {
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
    public String postUpdateUser(@ModelAttribute("newUser") User user, Model model) {
        System.out.println(user);
        User currentUser = userService.getUserById(user.getId());
        System.out.println(currentUser);
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
    public String postDeleteUser(Model model, @ModelAttribute("newUser") User user) {
        userService.deleteUserById(user.getId());
        return "redirect:/admin/user";
    }
}
