package com.example.fiegnuser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.FiegnClient.OrderClient;
import com.example.dto.Orders;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	OrderClient orderClient;
	
	@GetMapping("")
	public List<Orders> getUserOrders() {
		return orderClient.getAll();
	}
	
	@GetMapping("/{userId}")
	public List<Orders>  getUserOrdersById(@PathVariable String userId) {
		return orderClient.getAllById(userId);
	}
	
	@GetMapping("/byparam")
	public List<Orders> getUserOrdersByReqParam(@RequestParam String userId) {
		return orderClient.getAllByReqParam(userId);
	}
	
	@GetMapping("/postparam")
	public List<Orders> testPostWithParam(){
		return orderClient.getAllByPostReqParam();
	}
	
	@GetMapping("/bybody")
	public Orders testPostWithBody() {
		Orders orders = new Orders();
		orders.setId(1234);
		orders.setDescription("sales");
		return orderClient.getAllByPostReqBody(orders);
	}
	
}
