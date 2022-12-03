package com.java.controller;

import com.java.entity.User;
import com.java.service.UserService;
import com.java.vo.ResponseTemplateView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        log.info("saveUser inside UserController");
        return userService.saveUser(user);
    }
    @GetMapping("/{id}")
    public ResponseTemplateView getUserWithDepartment(@PathVariable("id") Long userId){
        log.info("getUser inside UserController");
        return  userService.getUserWithDepartment(userId);
    }



}
