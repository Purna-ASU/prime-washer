package com.prime.washer.controller;

import com.prime.washer.model.Users;
import com.prime.washer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private UserRepository usersRepository;

    // Create operation
    @PostMapping("/add")
    public Users addUser(@RequestBody Users user) {
        return usersRepository.save(user);
    }

    // Read operation
    @GetMapping("/all")
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    // Read operation by ID
    @GetMapping("/{id}")
    public Optional<Users> getUserById(@PathVariable("id") long id) {
        return usersRepository.findById(id);
    }

    // Update operation
    @PutMapping("/{id}")
    public Users updateUser(@PathVariable("id") long id, @RequestBody Users updatedUser) {
        updatedUser.setId(id);
        return usersRepository.save(updatedUser);
    }

    // Delete operation
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") long id) {
        usersRepository.deleteById(id);
    }
}
