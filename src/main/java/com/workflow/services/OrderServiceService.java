package com.workflow.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workflow.domain.Adress;
import com.workflow.domain.OrderService;
import com.workflow.repositories.OrderServiceRepository;

@Service
public class OrderServiceService {
	
	@Autowired
	OrderServiceRepository orderServiceRepo; 
	
	public OrderService find(Integer id) {
		Optional<OrderService> obj = orderServiceRepo.findById(id);
		return obj.orElse(null);
	}

}
