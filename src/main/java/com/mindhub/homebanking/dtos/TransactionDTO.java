package com.mindhub.homebanking.dtos;

import com.mindhub.homebanking.models.Transaction;
import com.mindhub.homebanking.models.TransactionType;
import java.time.LocalDateTime;
import com.mindhub.homebanking.models.Account;
import com.mindhub.homebanking.models.Transaction;
import com.mindhub.homebanking.models.TransactionType;
import java.time.LocalDate;
public class TransactionDTO {

        private Long id;
        private TransactionType type;
        private double amount;
        private String description;
        private LocalDate date;
        private Account account;

        public TransactionDTO(Transaction transaction) {
            this.type = transaction.getType();
            this.amount = transaction.getAmount();
            this.description = transaction.getDescription();
            this.date = transaction.getDate();
        }

        public Long getId() {
            return id;
        }
        public TransactionType getType() {
            return type;
        }
        public double getAmount() {
            return amount;
        }
        public String getDescription() {
            return description;
        }
        public LocalDate getDate() {
            return date;
        }
        public Account getAccount() {
            return account;
        }
    }