package com.example.weblab4.Controller;

import com.example.weblab4.Repository.UserRepository;
import com.example.weblab4.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping
    @RequestMapping("/createUser")
    public User createUser() {
        User user = new User();
        user.setName("nameUser");
        user.setPhone("88888");
        return userRepository.save(user);
    }
}

