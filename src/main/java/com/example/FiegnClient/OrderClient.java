package com.example.FiegnClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dto.Orders;

//@FeignClient(value="order-service",url="http://localhost:8081/demo/orders")
@FeignClient(name="Fiegn-User-Service")
public interface OrderClient {

	@GetMapping("")
	public List<Orders> getAll();
	
	@GetMapping("/{userId}")
	public List<Orders> getAllById(@PathVariable String userId);
	
	@GetMapping("/byparam")
	public List<Orders> getAllByReqParam(@RequestParam String userId);
	
	@PostMapping("/byparam")
	public List<Orders> getAllByPostReqParam();
	
	@PostMapping("/bybody")
	public Orders getAllByPostReqBody(@RequestBody Orders order);
	
}
