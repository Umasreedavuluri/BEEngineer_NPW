package com.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.cart.model.Item;
import com.shopping.cart.service.OrderService;


@RestController
public class OrderController {


	@Autowired
	private OrderService orderService;
	
    @RequestMapping("/call")
    public String call() {
    	return "";
    }
    
    @GetMapping("/order/{orderId}")
	public com.shopping.cart.model.Order findOrderById(@PathVariable String orderId) {
		return orderService.retrieveOrder(orderId);
	}
    
    @PostMapping("/orderactions/acceptShipDate")
	public ResponseEntity<Void> acceptShipDateChange(@RequestBody com.shopping.cart.model.Order orderReq) {
		com.shopping.cart.model.Order order = orderService.updateOrder(orderReq);
		if (order==null)
			return ResponseEntity.notFound().build();

		return ResponseEntity.status(200).build();

	}
    
    @PostMapping("/orderactions/cancelItem")
	public ResponseEntity<Void> cancelItem(@RequestBody Item itemReq) {
		Item itemResp = orderService.cancelItem(itemReq);
		if (itemResp == null)
			return ResponseEntity.notFound().build();

		return ResponseEntity.status(200).build();
	}
    
    @PostMapping("/orderactions/cancelOrder")
	public ResponseEntity<Void> cancelOrder(@RequestBody com.shopping.cart.model.Order orderReq) {
    	com.shopping.cart.model.Order orderResp = orderService.cancelOrder(orderReq);
		if (orderResp == null)
			return ResponseEntity.notFound().build();

		return ResponseEntity.status(200).build();
	}

}
