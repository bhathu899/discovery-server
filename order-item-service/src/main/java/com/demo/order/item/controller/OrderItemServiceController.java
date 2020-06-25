package com.demo.order.item.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.order.item.exception.OrderItemNotFound;
import com.demo.order.item.model.OrderItem;
import com.demo.order.item.service.OrderItemService;

@RestController
public class OrderItemServiceController {

	@Autowired
	OrderItemService orderItemService;

	@GetMapping("/orderitem")
	private List<OrderItem> getAllOrderItem() {
		return orderItemService.getAllOrderItem();
	}

	@PostMapping("/orderitem")
	private OrderItem saveOrderItem(@Valid @RequestBody OrderItem orderItem) {
		orderItemService.addOrderItem(orderItem);
		return orderItem;
	}

	@GetMapping("/orderitem/{productcode}")
	private OrderItem getOrderItem(@PathVariable("productcode") String productCode) {
		try {
			return orderItemService.getOrderItemByProductCode(productCode);
		} catch (Exception ex) {
			throw new OrderItemNotFound();

		}
	}
}
