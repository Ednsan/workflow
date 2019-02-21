package com.workflow.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="ADRESS")
public class Adress implements Serializable {
	private static final long serialVersionUID = 12345L; 

	//attr
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id; 
	private String street; 
	private String discrict ; 
	private String number; 
	private String complement;
	private String postalCode; 
	private City city;  //nao precisa de um ponteiro para o estado, ja que a cidade aponta para o mesmo.

	@ManyToMany
	@JoinTable(name="CLIENT_ADRESS", joinColumns = @JoinColumn(name="adress_id")
	, inverseJoinColumns = @JoinColumn(name="client_id")			)
	private List<Client> clients = new ArrayList<>();//VERIFICAR SE ISSO TEM SENTIDO 
	
	
	//constructors	
	public Adress() {
	
	}
	public Adress(Integer id, String street, String discrict, String number, String complement, String postalCode,
			 City city) {
		super();
		this.id = id;
		this.street = street;
		this.discrict = discrict;
		this.number = number;
		this.complement = complement;
		this.postalCode = postalCode;
		
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
	public List<Client> getClient() {
		return clients;
	}
	public void setClient(List<Client> clients) {
		this.clients = clients;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
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
		Adress other = (Adress) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	}
