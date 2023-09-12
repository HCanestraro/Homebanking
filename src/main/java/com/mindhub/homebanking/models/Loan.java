package com.mindhub.homebanking.models;

import com.mindhub.homebanking.dtos.AccountDTO;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Loan {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private long id;
	private String name;
	private double maxAmount;
	private double amount;
	
	@ElementCollection
	private List<Integer> payments= new ArrayList<>();
	@OneToMany(mappedBy = "loan", fetch=FetchType.EAGER)
	private Set<ClientLoan> clientLoans;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "account_id")
	private Account accounts;
	public Loan() {
	}
	
	public Loan(String name, double maxAmount, List<Integer> payments) {
		this.name = name;
		this.maxAmount = maxAmount;
		this.payments = payments;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getMaxAmount() {
		return maxAmount;
	}
	public void setMaxAmount(double maxAmount) {
		this.maxAmount = maxAmount;
	}
	public List<Integer> getPayments() {
		return payments;
	}
	public void setPayments(List<Integer> payments) {
		this.payments = payments;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public Set<ClientLoan> getClientLoans() {
		return clientLoans;
	}
	public void setClientLoans(Set<ClientLoan> clientLoans) {
		this.clientLoans = clientLoans;
	}
	public void addLoans(ClientLoan clientLoan){
		clientLoan.setLoan(this);
		clientLoans.add(clientLoan);
	}
	public Account getAccounts() { return accounts; }
	public void setAccounts(Account accounts) { this.accounts = accounts; }
}