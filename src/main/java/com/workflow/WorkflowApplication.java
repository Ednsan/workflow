package com.workflow;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WorkflowApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkflowApplication.class, args);
		
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		 EntityManager em = emf.createEntityManager();
		 
				 
	}

}

