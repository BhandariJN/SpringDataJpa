package com.jn.springdatajpa.Repositories;

import com.jn.springdatajpa.model.Authors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepositories extends JpaRepository<Authors, Integer> {

}
