package com.example.controllers;

import com.example.entities.User;
import com.example.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class UserController {
    private  final UserRepository userRepository;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAll(){
        List<User> users =  new ArrayList<>();
        userRepository.findAll().forEach(x -> { users.add(x);});
        if (users.size() != 0)
            return new ResponseEntity<>(users, HttpStatus.OK);
        else
            return new ResponseEntity<>(users, HttpStatus.EXPECTATION_FAILED);
    }

    @PostMapping("/users")
    public ResponseEntity<User> add(@RequestBody User user){
        return new ResponseEntity<>(userRepository.save(user), HttpStatus.CREATED);
    }
}
