package com.example.nawafotayf.movielist;

import 	com.example.nawafotayf.movielist.entity.Roles;
import com.example.nawafotayf.movielist.entity.Users;
import com.example.nawafotayf.movielist.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.LocalDate;

@SpringBootApplication
public class MovieListApplication implements CommandLineRunner{

	@Autowired
	UsersRepository usersRepository;
	public static void main(String[] args) {
		SpringApplication.run(MovieListApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Users adminAccount = usersRepository.findByroles(Roles.ADMIN);
		if(adminAccount == null){
			Users users = new Users();

			users.setUsername("admin");
			users.setEmail("admin@gmail.com");
			users.setDob(LocalDate.ofEpochDay(1998-02-03));
			users.setPassword(new BCryptPasswordEncoder().encode("admin"));
			users.setRoles(Roles.ADMIN);
			usersRepository.save(users);
		}
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry){
				registry.addMapping("/**").allowedMethods("*").allowedOrigins("*").allowedHeaders("*");
				;
			}
		};
	}
}
