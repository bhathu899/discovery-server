package com.demo.order.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItem {

	private String productCode;

	private String productName;

	private int quantity;

}
