package com.demo.order.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.order.exception.OrderNotFoundException;
import com.demo.order.feign.client.OrderItemsClient;
import com.demo.order.model.Order;
import com.demo.order.service.OrderService;

@RestController
public class OrderServiceController {
	@Autowired
	OrderService orderService;

	@Autowired
	OrderItemsClient orderItemsClient;

	@GetMapping("/orders")
	private List<Order> getAllOrderItem() {
		return orderService.getAllOrders();
	}

	@PostMapping("/orders")
	private Order saveOrderItem(@Valid @RequestBody Order order) {
		orderService.addOrderItem(order);
		orderItemsClient.create(order.getOrderItem());
		return order;
	}

	@GetMapping("/orders/{customername}")
	private Order getOrderInfo(@PathVariable("customername") String customerName) {
		try {
			Order order = orderService.getOrderByProductCode(customerName);
			order.setOrderItem(orderItemsClient.getProductByCode(order.getProductCode()));
			return order;

		} catch (Exception ex) {
			throw new OrderNotFoundException();
		}
	}
}
