package kata.spring.boot.PP_311.controller;

import kata.spring.boot.PP_311.model.UserModel;
import kata.spring.boot.PP_311.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "usersList";
    }

    @GetMapping("/new")
    public String newUserForm(Model model) {
        model.addAttribute("user", new UserModel());
        return "userForm";
    }

    @PostMapping("/save")
    public String saveUser(@RequestParam("id") long id,
                           @RequestParam("username") String username,
                           @RequestParam("email") String email,
                           @RequestParam("password") String password) {
        UserModel user;
        if (id > 0) { // существующий пользователь - обновление
            user = userService.getUserById(id);
            if (user == null) {
                user = new UserModel();
                user.setId(id);
            }
            user.setUsername(username);
            user.setEmail(email);
            user.setPassword(password);
            userService.updateUser(user);
        } else { // новый пользователь - сохранение
            user = new UserModel();
            user.setUsername(username);
            user.setEmail(email);
            user.setPassword(password);
            userService.saveUser(user);
        }
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String editUser(@RequestParam("id") long id, Model model) {
        UserModel user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "userForm";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }
}