package com.jn.springdatajpa.Repositories;

import com.jn.springdatajpa.model.Text;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TextRepositories extends JpaRepository<Text,Integer> {
}
