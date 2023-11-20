package com.example.nawafotayf.movielist.controller;

import com.example.nawafotayf.movielist.dto.JwtAuthenticationRequest;
import com.example.nawafotayf.movielist.dto.SignInRequest;
import com.example.nawafotayf.movielist.dto.SignUpRequest;
import com.example.nawafotayf.movielist.dto.UserVerify;
import com.example.nawafotayf.movielist.entity.Users;
import com.example.nawafotayf.movielist.repository.UsersRepository;
import com.example.nawafotayf.movielist.service.implementations.AuthenticationServiceImpl;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/movielist/auth")
@NoArgsConstructor
public class AuthController {
    @Autowired
    private AuthenticationServiceImpl authenticationService;
    @Autowired
    private UsersRepository usersRepository;

    @PostMapping(value = "/signup")
    public ResponseEntity<?> signup(@RequestBody SignUpRequest signUpRequest){
        try{
            authenticationService.signUp(signUpRequest);
            String message = "your account added successfully";
            Map<String, String> response = new HashMap<>();
            response.put("message", message);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }
        catch (Exception e){
            String message = "account not added\n" + e.getMessage();
            return ResponseEntity.badRequest().body(message);
        }
    }
    @PostMapping(value = "/signin")
    public ResponseEntity<JwtAuthenticationRequest> signin(@RequestBody SignInRequest signInRequest){
        return ResponseEntity.ok(authenticationService.signIn(signInRequest));
    }
    @GetMapping("/verify")
    public UserVerify verifyToken(Authentication authentication){
        Users user = (Users) authentication.getPrincipal();
        Users userFromDb = usersRepository.findByusername(user.getUsername());
        UserVerify userVerify = new UserVerify(userFromDb.getId(), userFromDb.getUsername(), userFromDb.getRoles());
        return userVerify;
    }
}
