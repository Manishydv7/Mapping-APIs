package com.springbootorm.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="laptop")
public class LaptopsOTM {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int lapId;
	private String purchaseDate;
	private float lapPrice;
	private String lapColour;

}
