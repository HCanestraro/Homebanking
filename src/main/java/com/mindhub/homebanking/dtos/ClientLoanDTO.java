package com.mindhub.homebanking.dtos;

import com.mindhub.homebanking.models.ClientLoan;

public class ClientLoanDTO {

    private long id;
    private long loanId;
    private String name;
    private double amount;
    //private Int payments;
    private String loanName;
    private double totalAmount;
    private String account;

    public ClientLoanDTO(ClientLoan clientLoan) {
        this.id = clientLoan.getId();
        this.loanId = clientLoan.getLoan().getId();
        this.name = clientLoan.getLoan().getName();
        this.amount = clientLoan.getAmount();
        this.loanName = clientLoan.getLoan().getName();
       // this.payments = clientLoan.getPayments();
//        this.totalAmount = clientLoan.getTotalAmount();
//        this.account = clientLoan.getAccount();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getLoanId() {
        return loanId;
    }

    public void setLoanId(long loanId) {
        this.loanId = loanId;
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

    //public Int getPayments() {
    //    return payments;
    //}

    //public void setPayments(Int payments) {
    //    this.payments = payments;
    //}

    public String getLoanName() {
        return loanName;
    }

    public void setLoanName(String loanName) {
        this.loanName = loanName;
    }

    //public double getTotalAmount() {
    //    return totalAmount;
    //}

   // public void setTotalAmount(double totalAmount) {
   //     this.totalAmount = totalAmount;
    //}

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}