package com.workflow.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workflow.domain.Skill;
import com.workflow.domain.Specialization;
import com.workflow.repositories.SkillRepository;
import com.workflow.repositories.SpecializationRepository;

@Service
public class SpecializationService {

	@Autowired
	SpecializationRepository specializationRepo; 
	

	public Specialization find(Integer id) {
		Optional<Specialization> obj = specializationRepo.findById(id);
		return obj.orElse(null);
	}
	
}
