package com.mindhub.homebanking.models;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import java.util.HashSet;
//import java.util.Set;

@Entity
public class Client {
	@javax.persistence.Id
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id;
	private String firstName;
	private String lastName;
	private String email;


	public Client() {
		this.firstName = "";
		this.lastName = "";
		this.email = "";
	}

	public Client(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}



