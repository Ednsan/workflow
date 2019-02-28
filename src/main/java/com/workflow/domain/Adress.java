package com.workflow.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Adress implements Serializable {
	private static final long serialVersionUID = 12345L; 
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id; 
	
	private String street; 
	private String discrict ; 
	private String number; 
	private String complement;
	private String postalCode; 
	
	@JsonBackReference
	@ManyToOne(cascade=CascadeType.ALL)
	private Client client; 
	
	@ManyToOne
	@JoinColumn(name="city_id")
	private City city;  //nao precisa de um ponteiro para o estado, ja que a cidade aponta para o estado

	//constructors	
	public Adress() {
	
	}
	public Adress(Integer id, String street, String discrict, String number, String complement, String postalCode,
			 Client client, City city) {
		super();
		this.id = id;
		this.street = street;
		this.discrict = discrict;
		this.number = number;
		this.complement = complement;
		this.postalCode = postalCode;
		this.client = client; 		
		this.city = city;
	}

	//gets and sets
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getDiscrict() {
		return discrict;
	}
	public void setDiscrict(String discrict) {
		this.discrict = discrict;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getComplement() {
		return complement;
	}
	public void setComplement(String complement) {
		this.complement = complement;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
	this.client = client;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
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
		Adress other = (Adress) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	}
