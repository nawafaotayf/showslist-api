package com.example.nawafotayf.movielist.service.implementations;

import com.example.nawafotayf.movielist.entity.Users;
import com.example.nawafotayf.movielist.repository.UsersRepository;
import com.example.nawafotayf.movielist.service.interfaces.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UsersService {
    @Autowired
    UsersRepository usersRepository;

    @Override
    public List<Users> listAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public Users findUserById(int id) {
        return usersRepository.findById(id).get();
    }

    @Override
    public void deleteUser(int id) {
        Users users = usersRepository.findById(id).get();
        usersRepository.delete(users);
    }
    @Override
    public void updateUser(int id, Users users) {
        Users findUsers = usersRepository.findById(id).get();
        if(users.getUsername() != null){
            findUsers.setUsername(users.getUsername());
        }
        if(users.getPassword() !=null){
            findUsers.setPassword(users.getPassword());
        }
        if(users.getEmail() !=null){
            findUsers.setEmail(users.getEmail());
        }
        if(users.getDob() != null){
            findUsers.setDob(users.getDob());
        }
        usersRepository.save(findUsers);
    }

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
               UserDetails userDetails =  usersRepository.findByusername(username);
               if(userDetails == null){
                   throw new UsernameNotFoundException("User not found");
               }
               return userDetails;
            }
        };
    }

}

