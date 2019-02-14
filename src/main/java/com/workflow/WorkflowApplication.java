package com.workflow;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.workflow.domain.*;
import com.workflow.repositories.SkillRepository;


@SpringBootApplication
public class WorkflowApplication implements CommandLineRunner{

	
	@Autowired
	private SkillRepository skillRepo; 
	public static void main(String[] args) {
		SpringApplication.run(WorkflowApplication.class, args);
		
				 
	}

	@Override
	public void run(String... args) throws Exception {
	
		
	}

}

