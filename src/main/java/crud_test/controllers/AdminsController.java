package crud_test.controllers;

import crud_test.entities.User;
import crud_test.services.RoleService;
import crud_test.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminsController {

    private UserService userService;
    private RoleService roleService;

    @Autowired
    public AdminsController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("")
    public String getUsers(Model model) {

        model.addAttribute("users", userService.getUsers());
        model.addAttribute("user",new User());
        model.addAttribute("allRoles", roleService.getRolesList());
        return "users";
    }

    @PostMapping("/adduser")
    public String addUser(@Validated(User.class) @ModelAttribute("user") User user ) {
        userService.addOrUpdate(user);
        return "redirect:/admin";
    }

    @GetMapping("/{id}/delete")
    public String deleteUser(@PathVariable Long id) {
        userService.remove(id);
        return "redirect:/admin";
    }
}
