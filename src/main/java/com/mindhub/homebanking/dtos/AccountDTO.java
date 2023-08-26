package com.mindhub.homebanking.dtos;

import com.mindhub.homebanking.models.Account;
import com.mindhub.homebanking.models.Client;
import java.time.LocalDate;
import java.util.Set;
//import com.mindhub.homebanking.Models.Transaction;

import java.time.LocalDate;
import java.util.Set;

	public class AccountDTO {
		private long id;

		private String number;

		private LocalDate creationDate;
		private double balance;
		//private Set<Transaction> transactions;
		public AccountDTO() {
		}

		public AccountDTO(Account account) {
			this.id = account.getId();
			this.number = account.getNumber();
			this.creationDate = account.getDate();
			this.balance = account.getBalance();
		//	this.transactions=account.getTransactions();
		}

		public LocalDate getCreationDate() {
			return creationDate;
		}

		//public Set<Transaction> getTransactions() {			return transactions;		}

		//public void setTransactions(Set<Transaction> transactions) {			this.transactions = transactions;		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getNumber() {
			return number;
		}

		public void setNumber(String number) {
			this.number = number;
		}

		public LocalDate getDate() {
			return creationDate;
		}

		public void setCreationDate(LocalDate creationDate) {
			this.creationDate = creationDate;
		}

		public double getBalance() {
			return balance;
		}

		public void setBalance(double balance) {
			this.balance = balance;
		}
	}