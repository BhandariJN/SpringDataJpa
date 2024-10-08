package com.jn.springdatajpa.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class Authors {
    @Id
    @GeneratedValue
           /* (
            strategy = GenerationType.SEQUENCE,
            generator = "author_sequence"
    )
    @SequenceGenerator(

            name = "author_sequence",
            sequenceName = "author_sequence",
            allocationSize = 1
    )
    @TableGenerator(name = "author_id_gen",
    table = "id_generation",
    pkColumnName = "id_name",
    valueColumnName = "id_value",
    allocationSize = 1)*/

    private Integer id;

    @Column(name = "f_name",
    length = 50,
    nullable = false)
    private String firstName;
    private String lastName;
    @Column(unique = true,
    nullable = false)
    private String email;
    private int age;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Column(insertable = false)
    private LocalDateTime modifiedAt;
}
