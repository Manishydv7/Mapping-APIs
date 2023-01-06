package com.springbootorm.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springbootorm.entities.ProductsMTM;

import com.springbootorm.exception.ResourceNotFoundException;
import com.springbootorm.repositories.ManyToManyRepository;

@RestController
public class ManyToManyController {

	@Autowired
	private ManyToManyRepository mtmRepo;

	// get all products
	@GetMapping("/productsmtm")
	public List<ProductsMTM> getAllStudents() {
		return mtmRepo.findAll();
	}

	// create products
	@PostMapping("/productsmtm")
	public ProductsMTM createProduct(@RequestBody ProductsMTM product) {
		return mtmRepo.save(product);
	}

	// get product
	@GetMapping("/productsmtm/{id}")
	public ResponseEntity<ProductsMTM> getProductById(@PathVariable int id) {
		ProductsMTM product = mtmRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Products not exist with id :" + id));
		return ResponseEntity.ok(product);
	}

	// update product

	@PutMapping("/productsmtm/{id}")
	public ResponseEntity<ProductsMTM> updateProduct(@PathVariable int id, @RequestBody ProductsMTM productMTM) {
		ProductsMTM product = mtmRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not exist with id :" + id));

		product.setId(productMTM.getId());
		product.setP_name(productMTM.getP_name());
		product.setCategories(productMTM.getCategories());

		ProductsMTM updatedProduct = mtmRepo.save(product);
		return ResponseEntity.ok(updatedProduct);
	}

	// delete product
	@DeleteMapping("/productsmtm/{id}")
	public ResponseEntity<Map<String, Boolean>>

			deleteStudent(@PathVariable int id) {
		ProductsMTM product = mtmRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not exist with id :" + id));

		mtmRepo.delete(product);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
