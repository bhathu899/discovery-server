package com.demo.order.feign.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.demo.order.model.OrderItem;

@FeignClient(name="order-item-service")
public interface OrderItemsClient {

    @GetMapping("/orderitem")
    List<OrderItem> listOfOrderItems();

    @GetMapping("/orderitem/{productCode}")
    OrderItem getProductByCode(@PathVariable String productCode);

    @PostMapping("/orderitem")
    OrderItem create(@RequestBody OrderItem orderItem);

  
}