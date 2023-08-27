package com.fahrul.bank.gita.controller;

import com.fahrul.bank.gita.entity.User;
import com.fahrul.bank.gita.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/profile")
	public String profile(Principal principal, Model model) {
		User user = userService.findByUsername(principal.getName());

		model.addAttribute("user", user);

		return "profile";
	}

	@PostMapping("/profile")
	public String profilePost(@ModelAttribute("user") User newUser, Model model) {
		User user = userService.findByUsername(newUser.getUsername());
		user.setUsername(newUser.getUsername());
		user.setFirstName(newUser.getFirstName());
		user.setLastName(newUser.getLastName());
		user.setEmail(newUser.getEmail());
		user.setPhone(newUser.getPhone());

		model.addAttribute("user", user);

		userService.saveUser(user);

		return "profile";
	}

}