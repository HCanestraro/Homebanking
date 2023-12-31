package com.mindhub.homebanking.dtos;

import com.mindhub.homebanking.models.ClientLoan;
import com.mindhub.homebanking.models.Client;

public class ClientLoanDTO {
	private long id;
	private long loanId;
	private String name;
	private double amount;
	private int payments;
	
	public ClientLoanDTO(ClientLoan clientLoan) {
		this.id=clientLoan.getId();
		this.loanId = clientLoan.getLoan().getId();
		this.name = clientLoan.getLoan().getName();
		this.amount =clientLoan.getAmount();
		this.payments = clientLoan.getPayments();
	}
	
	public long getId() {
		return loanId;
	}
	public void setId(long id) {
		this.loanId = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getPayments() {
		return payments;
	}
	public void setPayments(int payments) {
		this.payments = payments;
	}
}