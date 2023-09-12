package com.mindhub.homebanking.dtos;

import com.mindhub.homebanking.models.Account;
import com.mindhub.homebanking.models.Transaction;
import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.List;

public class AccountDTO {
    private long id;
	private String number;
	private LocalDate creationDate;
    private double balance;
    private Set<TransactionDTO> transactions;
    
    public AccountDTO() {
    }
    
    public AccountDTO(Account account) {
        this.id=account.getId();
        this.number = account.getNumber();
        this.creationDate = account.getDate();
        this.balance = account.getBalance();
        this.transactions = account.getTransactions().stream().map(TransactionDTO::new).collect(Collectors.toSet());
    }
	public LocalDate getCreationDate() {
        return creationDate;
    }
	public Set<TransactionDTO> getTransactions() {
        return transactions;
    }
	public long getId() {
        return id;
    }
	public void setId(long id) {
        this.id = id;
    }
	public String getNumber() {
        return number;
    }
	public LocalDate getDate() {
        return creationDate;
    }
	public double getBalance() {
        return balance;
    }
}