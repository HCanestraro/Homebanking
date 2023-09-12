package com.mindhub.homebanking.controllers;

import com.mindhub.homebanking.dtos.LoanApplicationDTO;
import com.mindhub.homebanking.dtos.LoanDTO;
import com.mindhub.homebanking.models.*;
import com.mindhub.homebanking.repositories.*;
import com.mindhub.homebanking.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class LoanController {
	@Autowired
	private ClientLoanService clientLoanService;
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private LoanService loanService;
	
	@Autowired
	private AccountRepository accountService;
	@Autowired
	private TransactionService transactionService;
	
	@GetMapping("/loans")
	public List<LoanDTO> getLoans() {
		return loanService.findAll().stream().map(loanName -> new LoanDTO(loanName)).collect(Collectors.toList());
		//return clientLoanRepository.findByClient(clientRepository.findByEmail(authentication.getName())).stream().map(clientLoan -> new ApplicationDTO(clientLoan)).collect(Collectors.toList());
	}
	
	
	@RequestMapping(path = "/loans", method = RequestMethod.POST)
	public ResponseEntity<Object> createLoan(@RequestBody LoanApplicationDTO loanApplicationDTO, Authentication authentication) {
		
		if (loanApplicationDTO == null) {
			
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		
		Loan newLoan = loanService.findById(loanApplicationDTO.getLoanId()).orElse(null);
		if (newLoan == null) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		Account account = accountService.findByNumber(loanApplicationDTO.getToAccountNumber());
		if (!account.getClient().equals(clientService.findByEmail(authentication.getName()))) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		
		
		if (account == null) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		Transaction transaction = new Transaction(TransactionType.CREDIT, loanApplicationDTO.getAmount(), loanApplicationDTO.getToAccountNumber() + " loan approved", LocalDate.now(), account);
		if (transaction.getAmount() > newLoan.getMaxAmount()) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		if (!newLoan.getPayments().contains(loanApplicationDTO.getPayments())) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		ClientLoan clientLoan = new ClientLoan(loanApplicationDTO.getAmount() * 1.2, loanApplicationDTO.getPayments());
		clientLoan.setLoan(newLoan);
		clientLoan.getLoan().setName(newLoan.getName());
		clientLoan.setClient(clientService.findByEmail(authentication.getName()));
		clientLoanService.save(clientLoan);
		account.setBalance(account.getBalance()+ transaction.getAmount());
		accountService.save(account);
		transactionService.save(transaction);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
}

/*@GetMapping("/loans")
	public List<LoanDTO> getLoans() {
		return loanService.findAll().stream().map(loanName -> new LoanDTO(loanName)).collect(Collectors.toList());
	}*/
	/*@Transactional
	@RequestMapping(path = "/loans", method = RequestMethod.POST)
	public ResponseEntity<Object> createLoan(@RequestBody LoanApplicationDTO loanApplicationDTO, Authentication authentication) {
		Loan currentLoan = loanService.getLoanById(loanApplicationDTO.getLoanId());
		Account destinyLoan = accountService.getAccountByNumber(loanApplicationDTO.getToAccountNumber());
		Client currentClient = clientService.getClientByEmail(authentication.getName());
		
		if (loanApplicationDTO.getAmount() <= 0) {
			return new ResponseEntity<>("Amount must be greater than zero", HttpStatus.FORBIDDEN);
		}
		if (loanApplicationDTO.getPayments() <= 0) {
			return new ResponseEntity<>("Amount of payments forbidden", HttpStatus.FORBIDDEN);
		}
		if (currentLoan == null) {
			return new ResponseEntity<>("Loan type not found", HttpStatus.FORBIDDEN);
		}
		if (!currentLoan.getPayments().contains(loanApplicationDTO.getPayments())) {
			return new ResponseEntity<>("amount of payments not available", HttpStatus.FORBIDDEN);
		}
		if (loanApplicationDTO.getAmount() > currentLoan.getMaxAmount()) {
			return new ResponseEntity<>("maximum loan amount allowed exceeded", HttpStatus.FORBIDDEN);
		}
		if (destinyAccount == null) {
			return new ResponseEntity<>("Destiny account does not exist in accounts", HttpStatus.FORBIDDEN);
		}
		if (!currentClient.getAccounts().contains(destinyAccount)) {
			return new ResponseEntity<>("Account not found in current client", HttpStatus.FORBIDDEN);
		}
		ClientLoan clientLoan = new ClientLoan(loanApplicationDTO.getAmount() * 1.2, loanApplicationDTO.getPayments());
		
		Transaction transaction = new Transaction(currentLoan.getName() + " - loan approved",
			loanApplicationDTO.getAmount(), LocalDateTime.now(), TransactionType.CREDIT);
		
		destinyAccount.setBalance(destinyAccount.getBalance() + loanApplicationDTO.getAmount());
		
		destinyAccount.addTransaction(transaction);
		
		currentLoan.addClientLoan(clientLoan);
		
		currentClient.addClientLoan(clientLoan);
		
		transactionService.saveTransaction(transaction);
		clientLoanService.saveClientLoan(clientLoan);
		
		ClientLoanDTO clientLoanDTO = new ClientLoanDTO(clientLoan);
		
		return new ResponseEntity<>(clientLoanDTO, HttpStatus.CREATED);
		
		@RequestMapping("/loans")
		public List<LoanDTO> getLoans() {
			return loanService.getLoans();
		}*/


/*
if (loanApplicationDTO == null) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		Loan newLoan = loanService.findById(loanApplicationDTO.getLoanId()).orElse(null);
		if (newLoan == null) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		Account account = accountService.findByNumber(loanApplicationDTO.getToAccountNumber());
		if (!account.getClient().equals(clientService.findByEmail(authentication.getName()))) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		if (account == null) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		Transaction transaction = new Transaction(TransactionType.CREDIT, loanApplicationDTO.getAmount(), loanApplicationDTO.getToAccountNumber() + " loan approved", LocalDate.now(), account);
		if (transaction.getAmount() > newLoan.getMaxAmount()) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		if (!newLoan.getPayments().contains(loanApplicationDTO.getPayments())) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		ClientLoan clientLoan = new ClientLoan(loanApplicationDTO.getAmount() * 1.2, loanApplicationDTO.getPayments());
		clientLoan.setLoan(newLoan);
		clientLoan.getLoan().setName(newLoan.getName());
		clientLoan.setClient(clientService.findByEmail(authentication.getName()));
		clientLoanService.save(clientLoan);
		account.setBalance(account.getBalance()+ transaction.getAmount());
		accountService.save(account);
		transactionService.save(transaction);
		return new ResponseEntity<>(HttpStatus.CREATED);
 */