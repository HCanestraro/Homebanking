package com.mindhub.homebanking.dtos;

import com.mindhub.homebanking.models.Transaction;
import com.mindhub.homebanking.models.TransactionType;

import java.time.LocalDate;
public class TransactionDTO {
    private Long id;
    private TransactionType type;
    private double amount;
    private String description;
    private LocalDate date;
    public long getId() {
        return id;
    }
    
    public TransactionType getType() {
        return type;
    }
    
    public double getAmount() {
        return amount;
    }
    
    public LocalDate getDate() {
        return date;
    }
    
    public String getDescription() {
        return description;
    }
}