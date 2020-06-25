package com.demo.order.service;

import org.springframework.data.repository.CrudRepository;

import com.demo.order.model.Order;
public interface OrderRepository  extends CrudRepository<Order, String> {

}
