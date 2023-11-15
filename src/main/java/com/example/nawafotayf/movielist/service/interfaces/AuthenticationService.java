package com.example.nawafotayf.movielist.service.interfaces;

import com.example.nawafotayf.movielist.dto.JwtAuthenticationRequest;
import com.example.nawafotayf.movielist.dto.SignInRequest;
import com.example.nawafotayf.movielist.dto.SignUpRequest;
import com.example.nawafotayf.movielist.entity.Users;

public interface AuthenticationService {
    public Users signUp(SignUpRequest signUpRequest);
    public JwtAuthenticationRequest signIn(SignInRequest signInRequest);
}
