package com.example.nawafotayf.movielist.service.interfaces;

import com.example.nawafotayf.movielist.entity.Roles;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;

public interface JWTService {
    public String generateToken(UserDetails userDetails, int id, Roles role);
    public String extractUsername(String token);
    boolean isTokenValid(String token, UserDetails userDetails);
    public String generateRefreshToken(Map<String, Object> extraClaims, UserDetails userDetails);

}
