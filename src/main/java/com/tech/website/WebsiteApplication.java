package com.tech.website;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.tech.website.pojo.User;
import com.tech.website.repository.UserRepository;

@SpringBootApplication
public class WebsiteApplication {

	UserRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(WebsiteApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public void run (String... args)throws Exception{
		repository.saveUser(new User("1", "Maramkhah", "Maksing"));
	}
}
