package com.workflow.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Specialization implements Serializable {
	private static final long serialVersionUID = 12345;
	
	
	//atributos
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id; 
	private String name; 	
	
	


	@JsonManagedReference	
	@OneToMany
	private List<Skill> skills = new ArrayList<>();
	
	@ManyToMany
	private List<Client> clients = new ArrayList<>();
	

	//constructors
	public Specialization(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;	
	}
	public Specialization() {
	
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
	public List<Skill> getSkills() {
		   for(Skill skill : skills) {
		        return skills;
		    }
		    return null;
	}
	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}	
	
	public List<Client> getClients() {
			return clients;
	}
	
	public void setClients(List<Client> clients) {
			this.clients = clients;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
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
		Specialization other = (Specialization) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Specialization [id=" + id + ", name=" + name + ", skills=" + skills + ", clients=" + clients + "]";
	}
	
	

	}

