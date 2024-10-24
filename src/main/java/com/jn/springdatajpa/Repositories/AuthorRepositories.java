package com.jn.springdatajpa.Repositories;

import com.jn.springdatajpa.model.Authors;
import jakarta.persistence.NamedQuery;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepositories extends JpaRepository<Authors, Integer>, JpaSpecificationExecutor<Authors> {

//named Query example


    List<Authors> findByNamedQuery(@Param("age") int age);



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

    @Modifying
    @Transactional
    @Query("update Authors a set a.age =:age where a.id=:id")
    int updateAuthorAge(int age, int id);


    @Modifying
    @Transactional
    @Query("update Authors a set a.age=:age")
    void updateAllAuthorsAge(int age);


    @Modifying
    @Transactional
    void updateByNamedQuery(@Param("age") int age);
}
