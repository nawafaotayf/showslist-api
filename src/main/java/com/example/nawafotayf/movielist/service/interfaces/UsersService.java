package com.example.nawafotayf.movielist.service.interfaces;

import com.example.nawafotayf.movielist.entity.Users;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface UsersService {
    public List<Users> listAllUsers();
    Users findUserById(int id);
    public void deleteUser(int id);
    public void updateUser(int id, Users users);
    public UserDetailsService userDetailsService();

}
