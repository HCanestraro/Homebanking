package com.mindhub.homebanking.dtos;

import com.mindhub.homebanking.models.Account;
import com.mindhub.homebanking.models.Client;
import com.mindhub.homebanking.models.Transaction;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class AccountDTO {
    private final Long id;
    private final String number;
    private final LocalDate creationDate;
    private final double balance;
    private Set<Transaction> transactions = new HashSet<>();
    private Client owner;

    public AccountDTO(Account account) {
        this.id = account.getId();
        this.number = account.getNumber();
        this.creationDate = account.getDate();
        this.balance = account.getBalance();
        this.transactions = account.getTransactions();
    }

    public Long getId() {
        return id;
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
    public Set<Transaction> getTransactions() {
        return transactions;
    }
}