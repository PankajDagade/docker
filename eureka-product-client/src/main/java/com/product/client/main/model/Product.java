package com.product.client.main.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "producttbl")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	
	@Id
	private String id;
	private String name;
	private String email;
	

}
