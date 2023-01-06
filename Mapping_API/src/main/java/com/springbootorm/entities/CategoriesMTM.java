package com.springbootorm.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="categories")
public class CategoriesMTM {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String c_title;
	
	@ManyToMany(mappedBy = "categories", fetch = FetchType.LAZY)
    
	@JsonBackReference
	private List<ProductsMTM> products = new ArrayList<>();
}
