package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.repo.UserRepository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserRepository userRepository;

    @GetMapping
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Integer id) {
        return userRepository.findById(id);
    }

    @PostMapping("/{name}/{email}")
    public String createUser(@PathVariable Map<String,String> map){
        User user = new User();
        user.setName(map.get("name"));
        user.setEmail(map.get("email"));
        userRepository.save(user);
        return "saved!";
    }

    @PutMapping("/{id}/{name}/{email}")
    public User updateUser(@PathVariable Integer id, @PathVariable String name, @PathVariable String email) {
        User user = userRepository.findById(id).get();
        user.setName(name);
        user.setEmail(email);
        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Integer id) {
        userRepository.deleteById(id);
        return "deleted!";
    }


}
