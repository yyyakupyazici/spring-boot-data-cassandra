package com.bezkoder.spring.data.cassandra.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.data.cassandra.dto.UserDto;
import com.bezkoder.spring.data.cassandra.model.User;
import com.bezkoder.spring.data.cassandra.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userservice;

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(userservice.saveUser(userDto), HttpStatus.CREATED);
    }
}
