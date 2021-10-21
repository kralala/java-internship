package hiber.controller;

import hiber.model.User;
import hiber.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get_user/{id}")
    public User findUserById(@PathVariable("id") UUID id) {
        return userService.findById(id);
    }

    @PostMapping("/delete_post/{id}")
    public void deleteUserById(@PathVariable("id") UUID id) {
        userService.deleteUserById(id);
    }

}
