package com.jn.springdatajpa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Course {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String title;
    private String description;

    @ManyToMany
    @JoinTable(
            name = "author_courses",
            joinColumns = {
                    @JoinColumn(name = "course_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "author_id")
            }
    )
    private List<Authors> authors;


    @OneToMany(mappedBy = "course")
    private List<Section> sections;
}
