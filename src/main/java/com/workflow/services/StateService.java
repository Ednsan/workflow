package com.workflow.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workflow.domain.Adress;
import com.workflow.domain.State;
import com.workflow.repositories.StateRepository;

@Service
public class StateService {
	
	@Autowired
	StateRepository stateRepo; 
	
	public State find(Integer id) {
		Optional<State> obj = stateRepo.findById(id);
		return obj.orElse(null);
	}

}
