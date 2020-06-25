package com.demo.order.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.order.model.Order;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;

	public List<Order> getAllOrders() {
		List<Order> orders = new ArrayList<Order>();
		orderRepository.findAll().forEach(order -> orders.add(order));
		return orders;
	} // getting a specific record

	public Order getOrderByProductCode(String productCode) {
		return orderRepository.findById(productCode).get();
	}

	public void addOrderItem(Order order) {
		orderRepository.save(order);
	}

}
