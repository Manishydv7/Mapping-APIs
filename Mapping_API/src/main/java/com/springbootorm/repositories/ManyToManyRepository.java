package com.springbootorm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootorm.entities.ProductsMTM;

@Repository
public interface ManyToManyRepository extends JpaRepository<ProductsMTM, Integer>{

}
