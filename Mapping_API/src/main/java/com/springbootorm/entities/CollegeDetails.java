package com.springbootorm.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "college_details")
public class CollegeDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int clg_id;
	private String clg_name;
	private String principal_name;
	private int pin;
	private String address;

}
