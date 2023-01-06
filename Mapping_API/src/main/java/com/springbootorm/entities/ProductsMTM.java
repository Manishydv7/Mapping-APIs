package com.springbootorm.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "products")
public class ProductsMTM {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String p_name;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "products_categories", joinColumns = {
			@JoinColumn(name = "product_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "categories_id", referencedColumnName = "id") })

	private List<CategoriesMTM> categories = new ArrayList<>();

}
