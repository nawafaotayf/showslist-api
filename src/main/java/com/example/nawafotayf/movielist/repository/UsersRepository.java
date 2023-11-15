package com.example.nawafotayf.movielist.repository;

import com.example.nawafotayf.movielist.entity.Roles;
import com.example.nawafotayf.movielist.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    Users findByusername(String name);
    Users findByroles(Roles roles);
}
