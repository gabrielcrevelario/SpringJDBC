package com.gabriel.crevelario.crevelario.controller;

import com.gabriel.crevelario.crevelario.models.User;
import com.gabriel.crevelario.crevelario.repository.UserRepository;
import com.gabriel.crevelario.crevelario.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @GetMapping
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @PostMapping(produces = "application/json")
    public User create(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PostMapping(value = "/login")
    public String login(@RequestParam String email,@RequestParam String senha ) {
       User logged = userRepository.login(email, senha);
       if(logged != null) {
           return "redirect:/user";
       }
       return "redirect:/user/login";

    }
    @GetMapping(value="/file")
    public void getFile() {
        userService.loadFile();
    }

    @PostMapping(value="/update")
    public void update(@RequestParam("file") MultipartFile file) {
      userService.update(file);
    }


}
