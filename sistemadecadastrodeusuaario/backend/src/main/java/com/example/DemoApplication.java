package com.example;

import com.example.entities.User;
import com.example.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserRepository userRepository){
		return args -> {
			Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
				User user = new User(name, name.toLowerCase() + "@outlook.com");
				userRepository.save(user);
			});
			userRepository.findAll().forEach(u -> {
				System.out.println(u.toString());
			});
		};
	}
}
