package com.workflow.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workflow.domain.Client;
import com.workflow.domain.Specialization;
import com.workflow.repositories.ClientRepository;
import com.workflow.repositories.SpecializationRepository;
import com.workflow.domain.*;

@Service
public class ClientService{
	
@Autowired
ClientRepository clientRepo; 


public Client find(Integer id) {
	Optional<Client> obj = clientRepo.findById(id);
	return obj.orElse(null);
}

}