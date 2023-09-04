package com.mindhub.homebanking.models;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id;
	private String email;
	private String firstName;
	private String lastName;
	private String password;

	@OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
	private Set<Account> accounts = new HashSet<>();

	@OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
	private Set<ClientLoan> clientLoans = new HashSet<>();

	@OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
	private Set<Card> cards = new HashSet<>();

	public Client(){
	}

	public Client(String email, String firstName, String lastName, String password) {
			this.email = email;
			this.firstName = firstName;
			this.lastName = lastName;
			this.password = password;
	}

	public Long getId() {
			return id;
		}
	public String getEmail() {
			return email;
		}
	public String getFirstName() { return firstName; }
	public String getLastName() {
			return lastName;
		}
	public Set<Account> getAccounts() {
			return accounts;
	}

	public Set<Loan> getLoans() { return this.clientLoans.stream().map(ClientLoan::getLoan).collect(Collectors.toSet()); }
	public void setAccounts(Set<Account> accounts) {
			this.accounts = accounts;
		}
		@JsonIgnore

	public Set<ClientLoan> getClientLoans() { return clientLoans; }
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setEmail(String email) { this.email = email; }
	public void setLoans(Set<ClientLoan> loans) {
		this.clientLoans = loans;
	}
	public Set<Card> getCards() {
			return cards;
		}
	public void setCards(Set<Card> cards) {
			this.cards = cards;
		}
	public void addAccount(Account account) {
		account.setOwner(this);
		accounts.add(account);
	}
	public void addLoan(ClientLoan loan) {
		this.clientLoans.add(loan);
	}
	public void addCard(Card card) {
		card.setClient(this);
		this.cards.add(card);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}