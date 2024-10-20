package com.jn.springdatajpa;

import com.jn.springdatajpa.Repositories.AuthorRepositories;
import com.jn.springdatajpa.model.Authors;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(
            AuthorRepositories authorRepositories)
    {
        return args -> {
          var author = Authors.builder()
                  .firstName("John")
                  .lastName("Doe")
                  .age(25)
                  .email("john@doe.com")
                 .build();
          authorRepositories.save(author);
        };

    }

}
