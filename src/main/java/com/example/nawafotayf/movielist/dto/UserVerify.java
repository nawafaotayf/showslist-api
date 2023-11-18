package com.example.nawafotayf.movielist.dto;

import com.example.nawafotayf.movielist.entity.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVerify {
    private int id;
    private String username;
    private Roles roles;
}
