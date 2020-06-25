package com.demo.order.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ORDERS")

public class Order {
	@Id
	@Column
	@NotNull(message = "Customer name cannot be missing or empty")
	@Size(min = 2, message = "Customer name must not be less than 2 characters")
	private String customerName;
	@Column
	@NotNull(message = "Product Code cannot be missing or empty")
	@Size(min = 2, max=4, message = "Product Code must be between 2 to 4 characters")
	private String productCode;
	@Column
	@NotNull(message = "order Date cannot be missing or empty")
	@JsonDeserialize(using = DateHandler.class)
	private LocalDate orderDate;
	@Column
	private String shippingAddress;
	@Column
	private int total;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@Transient
	private OrderItem orderItem;
}
