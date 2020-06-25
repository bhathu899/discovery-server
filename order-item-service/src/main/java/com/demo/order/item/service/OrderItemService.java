package com.demo.order.item.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.order.item.model.OrderItem;

@Service
public class OrderItemService {
	
	@Autowired
	OrderItemRepository orderItemRepository;

	
	public List<OrderItem> getAllOrderItem()   
	{  
	List<OrderItem> orderItems = new ArrayList<OrderItem>();  
	orderItemRepository.findAll().forEach(orderItem -> orderItems.add(orderItem));  
	return orderItems;  
	}  
	//getting a specific record  
	public OrderItem getOrderItemByProductCode(String productCode)   
	{  
	return orderItemRepository.findById(productCode).get();  
	}  
	public void addOrderItem(OrderItem orderItem)   
	{  
		orderItemRepository.save(orderItem);  
	}  
	  
}
