package com.workflow.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workflow.domain.Skill;
import com.workflow.domain.Specialization;
import com.workflow.repositories.SkillRepository;


@Service
public class DBService {
	
	@Autowired
	private SkillRepository skillRepo; 
	
	public void instantiateTestDatabase() {
		Specialization specialization1 = new Specialization(null, "Tecnology");
		Skill skill1 = new Skill(null, "Java", specialization1);
		Skill skill2 = new Skill(null, "PHP", specialization1);
		
	
		skillRepo.saveAll(Arrays.asList(skill1, skill2));
		
	}
}
