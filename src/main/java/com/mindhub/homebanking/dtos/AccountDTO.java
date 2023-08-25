package com.mindhub.homebanking.dtos;

import com.mindhub.homebanking.models.Account;
//import com.mindhub.homebanking.models.Client;
import java.time.LocalDateTime;
//import java.util.Set;

public class AccountDTO {
	private Long id;
	private String number;
	private LocalDateTime creationDate;
	private double balance;

	public AccountDTO() {
	}

	public AccountDTO(Account account) {
		this.id = account.getId();
		this.number = account.getNumber();
		this.creationDate = account.getCreationDate();
		this.balance = account.getBalance();
	}
}

