package com.workflow.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OrderService implements Serializable {
	private static final long serialVersionUID = 12345L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer id; 
	
	private String description;
	private Double valueInitial; 
	private Double valueFinal;
	private Date initialDate;  
	private Date finalDate;
	
	
	@ManyToOne
	private Client client ; 
	@ManyToOne
	private Client clientFreelancer; 
	
	// private List<Client> freelancersConcorrentes; //max 10
	@ManyToOne
	private Client clientFreelancerFinal; 
	
	//constructors
	public OrderService() {
	}
	
	public OrderService(Integer id, String description, Double valueInitial, Double valueFinal, Date initialDate,
			Date finalDate, Client client, Client clientFreelancer, Client clientFreelancerFinal) {
		super();
		this.id = id;
		this.description = description;
		this.valueInitial = valueInitial;
		this.valueFinal = valueFinal;
		this.initialDate = initialDate;
		this.finalDate = finalDate;
		this.client = client;
		this.clientFreelancer = clientFreelancer;
		this.clientFreelancerFinal = clientFreelancerFinal;
	}

	//gets and sets
	
	
	//hashcode and equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

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

	public Client getClientFreelancer() {
		return clientFreelancer;
	}

	public void setClientFreelancer(Client clientFreelancer) {
		this.clientFreelancer = clientFreelancer;
	}


	public Client getClientFreelancerFinal() {
		return clientFreelancerFinal;
	}

	public void setClientFreelancerFinal(Client clientFreelancerFinal) {
		this.clientFreelancerFinal = clientFreelancerFinal;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
