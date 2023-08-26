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
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class AccountController {
	@Autowired
	private AccountRepository accountRepository;

	@RequestMapping("/accounts")
	public List<AccountDTO> getAccounts(){
		List<Account> accountList = accountRepository.findAll();
		return accountList.stream().map(account -> new AccountDTO(account)).collect(Collectors.toList());
	}
	@RequestMapping("/accounts/{id}")
	public AccountDTO getAccount(@PathVariable Long id){
		Account account = accountRepository.findById(id).orElse(null);
		return new AccountDTO(account);
	}
}