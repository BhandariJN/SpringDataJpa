package com.jn.springdatajpa.Repositories;

import com.jn.springdatajpa.model.Authors;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepositories extends JpaRepository<Authors, Integer> {


    // select * from authors where first_name ="Bhandari"
    List<Authors> findAllByFirstName(String fn);

    // select * from authors where first_name ="bhandari"
    List<Authors> findAllByFirstNameIgnoreCase(String fn);


    // select * from authors where first_name like "%bh%"
    List<Authors> findAllByFirstNameContainingIgnoreCase(String fn);


    // select * from authors where first_name like "bh%"
    List<Authors> findAllByFirstNameStartsWithIgnoreCase(String fn);


    // select * from authors where first_name like "%bh"
    List<Authors> findAllByFirstNameEndsWithIgnoreCase(String fn);

    // select * from authors where first_name in ("jn","bhandari", "coding")
    List<Authors> findAllByFirstNameInIgnoreCase(List<String> fn);
}
