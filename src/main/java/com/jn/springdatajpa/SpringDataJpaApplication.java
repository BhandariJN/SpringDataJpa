package com.jn.springdatajpa;

import com.github.javafaker.Faker;
import com.jn.springdatajpa.Repositories.AuthorRepositories;
import com.jn.springdatajpa.Repositories.TextRepositories;
import com.jn.springdatajpa.model.Authors;
import com.jn.springdatajpa.model.Text;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringDataJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaApplication.class, args);
    }

   @Bean
    public CommandLineRunner commandLineRunner(
            AuthorRepositories authorRepositories,
    TextRepositories textRepositories
    )
    {
        return args -> {
            /*
            for(int i=0;i<50;i++){
                Faker faker = new Faker();

                var author = Authors.builder()
                        .firstName(faker.name().firstName())
                        .lastName(faker.name().lastName())
                        .age(faker.number().numberBetween(19,65))
                        .email(faker.internet().emailAddress())
                        .build();
                authorRepositories.save(author);
            }
            */







        /*  var text = Text.builder()
                  .name("Java")
                  .content("Java Programming")

                  .build();
          textRepositories.save(text);
        */
         /* List<Authors> containingAuthors = authorRepositories.findAllByFirstNameContainingIgnoreCase("Ro");

            System.out.println("After fetching authors, found: " + containingAuthors.size());

            for (Authors author : containingAuthors) {
                System.out.println(author.getFirstName() + " " + author.getLastName());
            }*/

            List<Authors> containingAuthors = authorRepositories.findAllByFirstNameEndsWithIgnoreCase("e");

            System.out.println("After fetching authors, found: " + containingAuthors.size());

            for (Authors author : containingAuthors) {
                System.out.println(author.getFirstName() + " " + author.getLastName());
            }

        };



    }


}
