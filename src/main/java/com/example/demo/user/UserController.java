package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController

public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user")
    public User getUser(int num) {
        //User user = userRepository.getOne(name);
        User user = userRepository.findByNum(num);
        return user;
    }

    @PostMapping("/user")
    public String insertUser(String name, int num) {

        User user = User.builder().name(name).num(num).build();
//        User user = new User();
//        user.setName(name);
//        user.setNum(num);
        userRepository.save(user);

        return "good";
    }
}
