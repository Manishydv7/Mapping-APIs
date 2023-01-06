package com.springbootorm.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "student_details")
public class StudentDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String first_name;
	private String last_name;
	@Column(name = "email",length = 30, unique = true)
	@NotNull(message="must include email in postman API")
	@NotBlank(message="must type value in email")
	@Email(message="please provide proper email id")
	private String email;
	@Column(name = "mobile_no",length=10)
	private String mobile_no;

	@OneToOne(cascade = CascadeType.ALL)
	private CollegeDetails c_details;
}
