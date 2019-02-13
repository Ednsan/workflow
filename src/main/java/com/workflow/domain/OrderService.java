package com.workflow.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class OrderService implements Serializable {
	private static final long serialVersionUID = 12345L;
	//attr
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer id; 
	private String description;
	private Double valueInitial; 
	private Double valueFinal;
	private Date initialDate;  
	private Date previsionDate;
	private Date finalDate;
	
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Client client;

	@ManyToOne
	@JoinColumn(name="freelancer_id")
	private Client clientFreela;

	@OneToMany
	private List<Client> freelancersCompeting; //freelancers concorrentes
 	
	//constructors
	public OrderService(Integer id, String description, Double valueInitial,
			Double valueFinal, Date initialDate, Date previsionDate, Date finalDate, Client client, Client clientFreela) {
		super();
		this.id = id;

		this.description = description;
		this.valueInitial = valueInitial;
		this.valueFinal = valueFinal;
		this.initialDate = initialDate;
		this.finalDate = finalDate;
		this.previsionDate = previsionDate;
		
	}
	
	public OrderService() {
		
	}
	
	//gets and sets
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getValueInitial() {
		return valueInitial;
	}
	public void setValueInitial(Double valueInitial) {
		this.valueInitial = valueInitial;
	}
	public Double getValueFinal() {
		return valueFinal;
	}
	public void setValueFinal(Double valueFinal) {
		this.valueFinal = valueFinal;
	}
	public Date getInitialDate() {
		return initialDate;
	}
	public void setInitialDate(Date initialDate) {
		this.initialDate = initialDate;
	}
	public Date getFinalDate() {
		return finalDate;
	}
	public void setFinalDate(Date finalDate) {
		this.finalDate = finalDate;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public Date getPrevisionDate() {
		return previsionDate;
	}

	public List<Client> getFreelancersCompeting() {
		return freelancersCompeting;
	}

	public void setFreelancersCompeting(List<Client> freelancersCompeting) {
		this.freelancersCompeting = freelancersCompeting;
	}

	public void setPrevisionDate(Date previsionDate) {
		this.previsionDate = previsionDate;
	}

	public Client getClientFreela() {
		return clientFreela;
	}

	public void setClientFreela(Client clientFreela) {
		this.clientFreela = clientFreela;
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
		OrderService other = (OrderService) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
