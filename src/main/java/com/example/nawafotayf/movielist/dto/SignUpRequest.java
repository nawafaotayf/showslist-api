package com.example.nawafotayf.movielist.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SignUpRequest {
    private String username;
    private String password;
    private String email;
    private LocalDate dob;

}
