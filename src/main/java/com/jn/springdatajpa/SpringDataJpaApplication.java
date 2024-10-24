package com.jn.springdatajpa;

import com.github.javafaker.Faker;
import com.jn.springdatajpa.Repositories.AuthorRepositories;
import com.jn.springdatajpa.Repositories.TextRepositories;
import com.jn.springdatajpa.model.Authors;
import com.jn.springdatajpa.model.Text;
import com.jn.springdatajpa.specifications.AuthorsSpecations;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
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

           /* List<Authors> containingAuthors = authorRepositories.findAllByFirstNameEndsWithIgnoreCase("e");

            System.out.println("After fetching authors, found: " + containingAuthors.size());

            for (Authors author : containingAuthors) {
                System.out.println(author.getFirstName() + " " + author.getLastName());
            }*/

          /*  var author = Authors.builder()
                    .id(1)
                    .firstName("Jhamkanath")
                    .lastName("Bhandari")
                    .age(23)
                    .email("jn@gmail.com")
                    .build();
            authorRepositories.save(author);*/


//
//            authorRepositories.updateAuthorAge(100,1);
//            var authors=  authorRepositories.findByNamedQuery(50);
//            System.out.println("number of Authors: "+authors.size());
//
//      authors.forEach(System.out::println);


//            authorRepositories.updateByNamedQuery(55);


            /*for(int i=0;i<50;i++){
                Faker faker = new Faker();
                authorRepositories.updateAuthorAge(faker.number().numberBetween(18,90),i);
            }
            */

            Specification<Authors> spec = Specification
                    .where(AuthorsSpecations.hasAge(49))
                    .and(AuthorsSpecations.firstNameLike("on"))
                    .and(AuthorsSpecations.modifiedOnDate(LocalDate.ofEpochDay(2024-10-20)));
            authorRepositories.findAll(spec).forEach(System.out::println);
        };
    }

}
