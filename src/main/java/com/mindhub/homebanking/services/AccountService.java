package com.mindhub.homebanking.services;
import com.mindhub.homebanking.dtos.AccountDTO;
import com.mindhub.homebanking.models.Account;
import com.mindhub.homebanking.models.Client;
import org.springframework.security.core.Authentication;

import java.util.List;
public interface AccountService {
	List<AccountDTO> getAccountsDTO();
	List<AccountDTO> getAccountsDTO(Client client);
	AccountDTO getAccountDTO(Long id);
	void createAccount(Authentication authentication) throws Exception;
	List<AccountDTO> getCurrentUserAccountsDTO(Authentication authentication);
	void SaveAccount(Account account);
	Account findById(Long id);
	Account findByNumber(String accountNumber);
	List<Account> findAll();
}
