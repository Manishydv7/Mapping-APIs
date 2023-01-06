package com.springbootorm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootorm.entities.StudentOTM;
@Repository
public interface OneToManyRepository extends JpaRepository<StudentOTM, Integer>{

}
