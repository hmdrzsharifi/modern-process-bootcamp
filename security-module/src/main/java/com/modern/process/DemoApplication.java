package com.modern.process;

import com.modern.process.domain.User;
import com.modern.process.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userRepository.save(new User("admin", "$2a$12$vciLgZAO6U4UFOSZeznJhuLTgHFHTbjsc0AT7eoQKnB6B11fOZkfK", "ADMIN"));
    }
}
