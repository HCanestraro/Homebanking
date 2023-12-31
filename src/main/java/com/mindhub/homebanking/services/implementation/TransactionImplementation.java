package com.mindhub.homebanking.services.implementation;

import com.mindhub.homebanking.dtos.TransactionDTO;
import com.mindhub.homebanking.models.Transaction;
import com.mindhub.homebanking.repositories.TransactionRepository;
import com.mindhub.homebanking.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionImplementation implements TransactionService {
	@Autowired
	TransactionRepository transactionRepository;
	
	@Override
	public List<TransactionDTO> findAll(){
		return transactionRepository.findAll().stream().map(transaction -> new TransactionDTO(transaction)).collect(Collectors.toList());
	}
	@Override
	public void save(Transaction transaction){
		transactionRepository.save(transaction);
	}
}