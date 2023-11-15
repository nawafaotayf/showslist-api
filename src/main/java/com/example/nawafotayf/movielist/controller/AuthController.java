package com.example.nawafotayf.movielist.controller;

import com.example.nawafotayf.movielist.dto.JwtAuthenticationRequest;
import com.example.nawafotayf.movielist.dto.SignInRequest;
import com.example.nawafotayf.movielist.dto.SignUpRequest;
import com.example.nawafotayf.movielist.entity.Users;
import com.example.nawafotayf.movielist.service.implementations.AuthenticationServiceImpl;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/movielist/auth")
@NoArgsConstructor
public class AuthController {
    @Autowired
    private AuthenticationServiceImpl authenticationService;

    @PostMapping(value = "/signup")
    public ResponseEntity<String> signup(@RequestBody SignUpRequest signUpRequest){
        try{
            authenticationService.signUp(signUpRequest);
        String message = "your account added successfully";
        return ResponseEntity.status(HttpStatus.CREATED).body(message);
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
}
