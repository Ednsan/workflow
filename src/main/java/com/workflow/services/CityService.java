package com.workflow.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workflow.domain.Adress;
import com.workflow.domain.City;
import com.workflow.repositories.CityRepository;

@Service
public class CityService {
	
	@Autowired
	CityRepository cityRepo; 
	
	public City find(Integer id) {
		Optional<City> obj = cityRepo.findById(id);
		return obj.orElse(null);
	}

}