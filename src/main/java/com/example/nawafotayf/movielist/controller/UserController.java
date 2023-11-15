package com.example.nawafotayf.movielist.controller;

import com.example.nawafotayf.movielist.entity.Users;
import com.example.nawafotayf.movielist.service.implementations.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@NoArgsConstructor
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping(value = "/movielist-admin/users/allusers")
    public List<Users> listAllUsers() {
        return userServiceImpl.listAllUsers();
    }
    @DeleteMapping(value = "/movielist-admin/users/deleteuser")
    public ResponseEntity<String> deleteUser(@RequestParam String name) {
        try {
            userServiceImpl.deleteUser(name);
            String message = "user deleted";
            return ResponseEntity.status(HttpStatus.OK).body(message);
        }
        catch (Exception e){
            String message = "user not deleted\n" + e.getMessage();
            return ResponseEntity.badRequest().body(message);
        }
    }

    @PutMapping(value = "/movielist-admin/users/updateuser")
    public ResponseEntity<String> updateUser(@RequestParam String name, @RequestBody Users users) {
        try{
            userServiceImpl.updateUser(name, users);
            String message = "user updated";
            return ResponseEntity.status(HttpStatus.OK).body(message);
    }
        catch (Exception e){
            String message = "user not updated\n" + e.getMessage();
            return ResponseEntity.badRequest().body(message);
        }
}
}
