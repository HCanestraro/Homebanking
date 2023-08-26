package com.mindhub.homebanking.controllers;

import com.mindhub.homebanking.dtos.AccountDTO;
import com.mindhub.homebanking.models.Account;
import com.mindhub.homebanking.models.Client;
import com.mindhub.homebanking.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;
import static java.util.stream.Collectors.toList;

@RestController
public class AccountController {
	@Autowired
	AccountRepository accountRepository;

	@RequestMapping("/api/accounts")
	public List<AccountDTO> getAccounts(){
		return accountRepository.findAll().stream().map(AccountDTO::new).collect(toList());
	}
	@RequestMapping("/api/accounts/{id}")
	public Optional<Account> getAccount(@PathVariable Long id){
		Optional<Account> account;
		account=accountRepository.findById(id);
			return account;
	}
}