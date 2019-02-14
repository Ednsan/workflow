package com.workflow;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mysql.fabric.xmlrpc.base.Array;
import com.workflow.domain.*;
import com.workflow.repositories.SkillRepository;
import com.workflow.repositories.SpecializationRepository;


@SpringBootApplication
public class WorkflowApplication implements CommandLineRunner{

	
	@Autowired
	private SkillRepository skillRepo; 
	
	
	@Autowired
	private SpecializationRepository specializationRepo; 
	
	public static void main(String[] args) {
		SpringApplication.run(WorkflowApplication.class, args);
		
				 
	}

	@Override
	public void run(String... args) throws Exception {
		
		Specialization spec1 = new Specialization(null, "Web Development");
		
		Skill skill1 = new Skill(null, "Java EE", spec1);
		Skill skill2 = new Skill(null, "PHP 7", spec1);
			
			specializationRepo.saveAll(Arrays.asList(spec1));
			skillRepo.saveAll(Arrays.asList(skill1, skill2));
	}	

}

