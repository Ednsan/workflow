package com.workflow.services;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workflow.domain.*;
import com.workflow.repositories.*;
import com.workflow.repositories.SkillRepository;

@Service
public class SkillService {
	
	@Autowired
	SkillRepository skillRepo; 
	

	public Skill find(Integer id) {
		Optional<Skill> obj = skillRepo.findById(id);
		return obj.orElse(null);
	}
	
	
}
