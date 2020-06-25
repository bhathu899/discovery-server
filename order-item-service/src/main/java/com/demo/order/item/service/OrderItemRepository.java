package com.demo.order.item.service;

import org.springframework.data.repository.CrudRepository; 
import com.demo.order.item.model.OrderItem;
public interface OrderItemRepository  extends CrudRepository<OrderItem, String> {

}
