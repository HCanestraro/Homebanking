package com.mindhub.homebanking;

import com.mindhub.homebanking.models.Account;
import static com.mindhub.homebanking.models.TransactionType.*;
import com.mindhub.homebanking.models.Client;
import com.mindhub.homebanking.models.Transaction;
import com.mindhub.homebanking.repositories.AccountRepository;
import com.mindhub.homebanking.repositories.ClientRepository;
import com.mindhub.homebanking.repositories.TransactionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.time.LocalDate;

@SpringBootApplication
public class HomebankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomebankingApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(ClientRepository clientRepository, AccountRepository accountRepository, TransactionRepository transactionRepository){
		return (args -> {
			Client client = new Client("Melba","Morel","melba@mindhub.com");
			clientRepository.save(client);
			Account account1 = new Account("VIN001", LocalDate.now(), 5000, client);
			accountRepository.save(account1);
			client.addAccount(account1);

			/*clientRepository.save(client1);
			clientRepository.save(client2);*/


			Account account2 = new Account("VIN002",LocalDate.now().plusDays(1),7500,client);
			accountRepository.save(account2);
			client.addAccount(account2);
			Transaction transaction = new Transaction(EXTRACTION, 1000.00, "extraction", LocalDate.now());

			transaction.setAccount(account1);
			account1.addTransaction(transaction);
			accountRepository.save(account1);
			transactionRepository.save(transaction);

			Transaction transaction1 =new Transaction(DEPOSIT, 5000, "deposit", LocalDate.now());
			transaction1.setAccount(account1);
			account1.addTransaction(transaction1);
			accountRepository.save(account1);
			transactionRepository.save(transaction1);

			/*Account account3 = new Account();
			account3.setNumber("VIN003");
			account3.setCreationDate( LocalDate.now().plusDays(5));
			account3.setBalance(75000.0);
			account3.setClient(client1);*/



			//accountRepository.save(account3);
		});
		}
	}