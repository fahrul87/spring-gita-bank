package com.fahrul.bank.gita.controller;

import com.fahrul.bank.gita.entity.PrimaryAccount;
import com.fahrul.bank.gita.entity.SavingsAccount;
import com.fahrul.bank.gita.entity.User;
import com.fahrul.bank.gita.repository.RoleDao;
import com.fahrul.bank.gita.security.UserRole;
import com.fahrul.bank.gita.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.HashSet;
import java.util.Set;


@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleDao roleDao;

    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/signup")
    public String signup(Model model) {
        User user = new User();

        model.addAttribute("user", user);

        return "signup";
    }

    @PostMapping("/signup")
    public String signupPost(@ModelAttribute("user") User user, Model model) {

        if (userService.checkUserExists(user.getUsername(), user.getEmail())) {

            if (userService.checkEmailExists(user.getEmail())) {
                model.addAttribute("emailExists", true);
            }

            if (userService.checkUsernameExists(user.getUsername())) {
                model.addAttribute("usernameExists", true);
            }

            return "signup";
        } else {
            Set<UserRole> userRoles = new HashSet<>();
            userRoles.add(new UserRole(user, roleDao.findByName("ROLE_USER")));

            userService.createUser(user, userRoles);

            return "redirect:/";
        }
    }

    @GetMapping("/userFront")
    public String userFront(Principal principal, Model model) {
        User user = userService.findByUsername(principal.getName());
        PrimaryAccount primaryAccount = user.getPrimaryAccount();
        SavingsAccount savingsAccount = user.getSavingsAccount();

        model.addAttribute("primaryAccount", primaryAccount);
        model.addAttribute("savingsAccount", savingsAccount);

        return "userFront";
    }
}