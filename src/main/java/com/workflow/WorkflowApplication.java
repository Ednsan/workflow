package com.workflow;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.workflow.domain.Adress;
import com.workflow.domain.City;
import com.workflow.domain.Client;
import com.workflow.domain.OrderService;
import com.workflow.domain.Skill;
import com.workflow.domain.Specialization;
import com.workflow.domain.State;
import com.workflow.repositories.AdressRepository;
import com.workflow.repositories.CityRepository;
import com.workflow.repositories.ClientRepository;
import com.workflow.repositories.SkillRepository;
import com.workflow.repositories.SpecializationRepository;
import com.workflow.repositories.StateRepository;


@SpringBootApplication
public class WorkflowApplication implements CommandLineRunner{

	
	@Autowired
	private SkillRepository skillRepo; 
	
	@Autowired
	private SpecializationRepository specializationRepo; 
	
	@Autowired
	private ClientRepository clientRepo; 
	
	
	@Autowired
	private AdressRepository adressRepo; 
	
	@Autowired
	private StateRepository StateRepo;
	
	@Autowired
	private CityRepository cityRepo;
	
	
	
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(WorkflowApplication.class, args);
		
				 
	}

	@Override
	public void run(String... args) throws Exception {
		
		//SPECIALIZATIONS
		Specialization spec1 = new Specialization(null, "Desenvolvimento Web ");
		Specialization spec2  = new Specialization(null, "Designer ");
		Specialization spec3 = new Specialization(null, "Marketing ");
		Specialization spec4 = new Specialization(null, "Outros ");
		 
		//SKILLS
		Skill skill1 = new Skill(null, "Ruby ", spec1);
		Skill skill2 = new Skill(null, "PHP 7 ", spec1);
		Skill skill3 = new Skill(null, "Adobe Photoshop ", spec2);
		Skill skill4 = new Skill(null, "Digital Marketing ", spec3);
		Skill skill5 = new Skill(null, "Construction worker ", spec4);
		Skill skill6 = new Skill(null, "Instalador de antenas ", spec4);
		
		//ESTATES AND CITIES
		State st1 = new State(null, "Rio de Janeiro");
		City city1 = new City(null, "Sao joao de meriti", st1);
		
		//NEW CLIENT
		Client cli1 = new Client (null, "Joao Batista", "73703756098", "joaobaptista@gmail.com");	
		Adress adress = new Adress(null, "Rua Ministro Joao Alberto", "Jardim Meriti", "148", "casa4", "25555-230", cli1, city1);
		
		
		//RELATIONS CLIENT
		cli1.setSkills(Arrays.asList(skill1));
		cli1.setSpecializations(Arrays.asList(spec1));
		cli1.getTelephones().addAll(Arrays.asList("21-990017845", "21-920029778"));	
		cli1.getAdress().addAll(Arrays.asList(adress));
		
		//RELATIONS SPEC	
		spec1.setSkills(Arrays.asList(skill1,skill2));
		spec2.setSkills(Arrays.asList(skill3));
		spec3.setSkills(Arrays.asList(skill4));
		spec4.setSkills(Arrays.asList(skill5, skill6));
		
			
		
		
		StateRepo.saveAll(Arrays.asList(st1));
		cityRepo.saveAll(Arrays.asList(city1));		
		specializationRepo.saveAll(Arrays.asList(spec1, spec2, spec3, spec4));
		skillRepo.saveAll(Arrays.asList(skill1, skill2, skill3, skill4, skill5, skill6));
		clientRepo.saveAll(Arrays.asList(cli1));
		adressRepo.saveAll(Arrays.asList(adress));
	}	

}

