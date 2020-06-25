package com.demo.order.item.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class OrderItem {
	@Id
	@Column
	@NotNull(message = "Product Code cannot be missing or empty")
	@Size(min = 2, max=4, message = "Product Code must be between 2 to 4 characters")
	private String productCode;
	@Column
	@NotNull(message = "Product name cannot be missing or empty")
	@Size(min = 2,  message = "Product name  must be bigger than 2 characters")
	private String productName;
	@Column
	@NotNull(message = "Quantity cannot be missing or empty")
	@Range(min = 1, max=1000, message = "Quantity must be between 1 to 1000")
	private int quantity;



}
