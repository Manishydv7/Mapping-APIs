package com.springbootorm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootorm.entities.StudentDetails;

@Repository
public interface OneToOneRepository extends JpaRepository<StudentDetails, Integer> {

}
