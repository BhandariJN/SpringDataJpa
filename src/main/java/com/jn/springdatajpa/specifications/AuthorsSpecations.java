package com.jn.springdatajpa.specifications;

import com.jn.springdatajpa.model.Authors;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class AuthorsSpecations {

    public static Specification<Authors> hasAge(int age){
        return (
                Root<Authors> root,
        CriteriaQuery<?> query,
                CriteriaBuilder builder
                )->{
            if(age<0){
                return  null;
            }
            return builder.equal(root.get("age"), age);
        };
    }

    public static Specification<Authors> firstNameLike(String firstName) {
        return (
                Root<Authors> root,
                CriteriaQuery<?> query,
                CriteriaBuilder builder
        ) -> {
            if (firstName == null) {
                return null;
            }
            return builder.like(root.get("firstName"), "%" + firstName + "%");
        };
    }

        public static Specification<Authors> lastNameLike(String lastName){
            return
                    (Root<Authors> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
                        if (lastName == null) {
                            return null;
                        }
                        return builder.like(root.get("lastName"), "%" + lastName + "%");

                    };

        }


        public static Specification<Authors> modifiedOnDate(LocalDate modifiedAt ) {

        return (
                Root<Authors> root,
                CriteriaQuery<?> query,
                        CriteriaBuilder builder
                )->{
            if(modifiedAt==null){
                return null;
            }
            return builder.equal(root.get("modifiedAt"), modifiedAt);
        };
        }

}
