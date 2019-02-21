package com.workflow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.workflow.domain.Client;
import com.workflow.domain.Skill;
import com.workflow.domain.Specialization;
import com.workflow.repositories.ClientRepository;
import com.workflow.repositories.SkillRepository;
import com.workflow.repositories.SpecializationRepository;


@SpringBootApplication
public class WorkflowApplication implements CommandLineRunner{

	
	@Autowired
	private SkillRepository skillRepo; 
	
	@Autowired
	private SpecializationRepository specializationRepo; 
	
	@Autowired
	private ClientRepository clientRepo; 
	
	
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(WorkflowApplication.class, args);
		
				 
	}

	@Override
	public void run(String... args) throws Exception {
		
		Specialization spec1 = new Specialization(null, "Web Development");
		Specialization spec2  = new Specialization(null, "Designer");

	
		Skill skill1 = new Skill(null, "Java EE", spec1);
		Skill skill2 = new Skill(null, "PHP 7", spec1);
		Skill skill3 = new Skill(null, "Adobe Photoshop", spec2);
		
		
		Client cli1 = new Client (null, "Joao Batista", "73703756098", "joaobaptista@gmail.com");	
			
		//spec1.getSkills().addAll(Arrays.asList(skill1, skill2)); 
		
		
		specializationRepo.saveAll(Arrays.asList(spec1, spec2));
		skillRepo.saveAll(Arrays.asList(skill1, skill2));
		clientRepo.saveAll(Arrays.asList(cli1));
	}	

}

