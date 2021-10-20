package crud_test.controllers;

import crud_test.entities.User;
import crud_test.services.RoleService;
import crud_test.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.security.Principal;

@Controller
@RequestMapping("/")
public class UserController {

	private UserService userService;
	private RoleService roleService;

	@Autowired
	public UserController(UserService userService,RoleService roleService) {

		this.userService = userService;
		this.roleService = roleService;
	}

	@GetMapping ("/user")
	public String userPage(Model model, Principal principal) {
		model.addAttribute("user", userService.loadUserByUsername(principal.getName()));
		model.addAttribute("allRoles", roleService.getRolesList());
		return "user";
	}

	@PostMapping("/adduser")
	public String addUser(@Validated(User.class) @ModelAttribute("user") User user ) {
		userService.addOrUpdate(user);
		return "redirect:/user";
	}

}