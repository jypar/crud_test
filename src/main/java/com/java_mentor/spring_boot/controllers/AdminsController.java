package com.java_mentor.spring_boot.controllers;

import com.java_mentor.spring_boot.entities.Role;
import com.java_mentor.spring_boot.entities.User;
import com.java_mentor.spring_boot.services.RoleService;
import com.java_mentor.spring_boot.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminsController {

    private UserServiceImpl userService;
    private RoleService roleService;

    @Autowired
    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("")
    public String getUsers(Model model) {
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/{id}/edit")
    public String getEditForm(@PathVariable Long id, Model model) {
        User userEdit = userService.findById(id);
        List<Role> roles = roleService.getRolesList();
        model.addAttribute("allRoles", roles);
        model.addAttribute("user", userEdit);
        return "update";
    }

    @PostMapping("/adduser")
    public String addUser(@Validated(User.class) @ModelAttribute("user") User user,
                          @RequestParam("authorities") List<String> values,
                          BindingResult result) {
        if(result.hasErrors()) {
            return "error";
        }
        Set<Role> roleSet = userService.getSetOfRoles(values);
        user.setRoles(roleSet);
        userService.addOrUpdate(user);
        return "redirect:/admin";
    }


    @GetMapping("/new")
    public String newUserForm(Model model) {
        model.addAttribute(new User());
        List<Role> roles = roleService.getRolesList();
        model.addAttribute("allRoles", roles);
        return "create";
    }

    @GetMapping("/{id}/delete")
    public String deleteUser(@PathVariable Long id, Model model) {
        User user = userService.findById(id);
        if(user != null) {
            userService.remove(id);
            model.addAttribute("messege", "user " + user.getUsername() + " succesfully deleted");
        } else {
            model.addAttribute("messege", "no such user");
        }

        return "redirect:/admin";
    }
}
