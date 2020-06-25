package com.demo.order.item.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class GlobalExceptionHandler {

	  @ExceptionHandler(value = OrderItemNotFound.class)
	   public ResponseEntity<Object> exception(OrderItemNotFound exception) {
	      return new ResponseEntity<>("Order Item not found", HttpStatus.NOT_FOUND);
	   }
}
