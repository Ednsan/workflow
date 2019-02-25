package com.workflow.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workflow.domain.Adress;
import com.workflow.repositories.AdressRepository;



@Service
public class AdressService {
	
	@Autowired
	AdressRepository adressRepo; 
	
	public Adress find(Integer id) {
		java.util.Optional<Adress> obj = adressRepo.findById(id);
		return obj.orElse(null);
	}

}
