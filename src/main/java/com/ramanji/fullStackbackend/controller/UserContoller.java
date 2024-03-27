package com.ramanji.fullStackbackend.controller;

import com.ramanji.fullStackbackend.exception.UserNotFoundException;
import com.ramanji.fullStackbackend.model.User;
import com.ramanji.fullStackbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000/")
public class UserContoller {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("user")
    User newUser(@RequestBody User newUser){
        return userRepository.save(newUser);
    }

    @GetMapping("users")
    List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("user/{id}")
    User getUserById(@PathVariable Long id) {
        return userRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException(id));
    }


    @PutMapping("/user/{id}")
    User updateUser(@RequestBody User newUser, @PathVariable Long id) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    return userRepository.save(user);
                }).orElseThrow(()->new UserNotFoundException(id));
    }


    @DeleteMapping("user/{id}")
    String deleteUser( @PathVariable Long id) {

        if(!userRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);

        return "User has been successfully deleted with id "+ id;

    }




}
