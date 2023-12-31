package com.mindhub.homebanking.models;

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
	private String password;
	@OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
	private Set<Account> accounts = new HashSet<>();
	@OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
	private Set<ClientLoan> loans = new HashSet<>();
	private double amount;
	
	@OneToMany(mappedBy = "client")
	private Set<Card> cards;
	public Client() {
	}
	
	public Client(String firstName, String lastName, String email, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Set<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void addAccount(Account account) {
		account.setClient(this);
		accounts.add(account);
	}
	public Set<ClientLoan> getClientLoans() {
		return loans;
	}
	public void addLoan(ClientLoan clientLoan) {
		clientLoan.setClient(this);
		loans.add(clientLoan);
		
	}
	public Set<Card> getCards() {
		return cards;
	}
	public void setCards(Set<Card> cards) {
		this.cards = cards;
	}
	public void addCards(Card card){
		card.setClient(this);
		cards.add(card);
	}
}