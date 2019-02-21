package com.workflow.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Client implements Serializable{
	private static final long serialVersionUID = 12345L; 
	
	
	//attr
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer id; 
	private String name;
	private String cpf ; 
	private String email; 
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "client_category",
	joinColumns = @JoinColumn(name = "client_id"),
	inverseJoinColumns = @JoinColumn(name = "specialization_id")
	)
	private List<Specialization> specializations = new ArrayList<>();
	

	@OneToMany
	private List<Skill> skills = new ArrayList<>() ; 	
	

	@JsonIgnore
	@OneToMany
	private List<OrderService> orderServices = new ArrayList<>();
		

	@ManyToMany
	@JsonIgnore
	private List<Adress> adress;
	
	
	
	@ElementCollection
	@CollectionTable(name ="TELEPHONE")
	private Set<String> telephones = new HashSet<>();
	
	


	//constructors
	public Client(Integer id, String name, String cpf, String email) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.email = email;
	}
	
	public Client() {
		
	}
	
	//gets and sets


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public List<Skill> getSkills() {
		return skills;
	}
	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Adress> getAdress() {
		return adress;
	}
	public void setAdress(List<Adress> adress) {
		this.adress = adress;
	}

	public Set<String> getTelephones() {
		return telephones;
	}

	public void setTelephones(Set<String> telephones) {
		this.telephones = telephones;
	}
	public List<Specialization> getSpecializations() {
		return specializations;
	}

	public void setSpecializations(List<Specialization> specializations) {
		this.specializations = specializations;
	}
	

	public List<OrderService> getOrderServices() {
		return orderServices;
	}

	public void setOrderServices(List<OrderService> orderServices) {
		this.orderServices = orderServices;
	}
	//hashcode and equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	} 
	
}
