package com.example.nawafotayf.movielist.service.implementations;

import com.example.nawafotayf.movielist.dto.JwtAuthenticationRequest;
import com.example.nawafotayf.movielist.dto.SignInRequest;
import com.example.nawafotayf.movielist.dto.SignUpRequest;
import com.example.nawafotayf.movielist.entity.Roles;
import com.example.nawafotayf.movielist.entity.Users;
import com.example.nawafotayf.movielist.repository.UsersRepository;
import com.example.nawafotayf.movielist.service.interfaces.AuthenticationService;
import com.example.nawafotayf.movielist.service.interfaces.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JWTService jwtService;
    @Override
    public Users signUp(SignUpRequest signUpRequest) {
        Users users = new Users();

        users.setUsername(signUpRequest.getUsername());
        users.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        users.setDob(signUpRequest.getDob());
        users.setRoles(Roles.USER);
        return usersRepository.save(users);
    }

    public JwtAuthenticationRequest signIn(SignInRequest signInRequest){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                signInRequest.getUsername(), signInRequest.getPassword()));
        var users = usersRepository.findByusername(signInRequest.getUsername());
        if(users == null){
            throw new UsernameNotFoundException("User not found");
        }
        var token = jwtService.generateToken(users);
        JwtAuthenticationRequest jwtAuthenticationRequest = new JwtAuthenticationRequest();

        jwtAuthenticationRequest.setToken(token);
        return jwtAuthenticationRequest;
    }
}
