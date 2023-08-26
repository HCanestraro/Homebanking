package com.mindhub.homebanking.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private long id;
	private String firstName;
	private String lastName;
	private String email;

//	@OneToMany(mappedBy="owner", fetch=FetchType.EAGER)
	@OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
	Set<Account> accounts = new HashSet<>();

	public Client() {
	//	this.firstName = "";
	//	this.lastName = "";
	//	this.email = "";
	}

	public Client(Long id, String firstName, String lastName, String email) {
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

	public Set<Account> getAccounts() { return accounts; }

}
