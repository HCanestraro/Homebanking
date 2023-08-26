package com.mindhub.homebanking.dtos;
import com.mindhub.homebanking.dtos.ClientDTO;
import com.mindhub.homebanking.models.Client;
import com.mindhub.homebanking.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Set;
public class ClientDTO {

		private Long id;
		private String firstName;
		private String lastName;
		private String email;
		private Set<AccountDTO> accounts;
	//	private Set<ClientLoanDTO> loans;

		public ClientDTO() {

		}

		public ClientDTO(Client client) {
			this.id = client.getId();
			this.firstName = client.getFirstName();
			this.lastName = client.getLastName();
			this.email = client.getEmail();
			this.accounts = client.getAccounts().stream().map(AccountDTO::new).collect(Collectors.toSet());
//        this.loans = client.getClientLoans().stream().map(ClientLoanDTO::new).collect(Collector.toSet());
		}

		public Long getId() {
			return id;
		}
		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public Set<AccountDTO> getAccounts() {
			return accounts;
		}

		public void setAccounts(Set<AccountDTO> accounts) {
			this.accounts = accounts;
		}
	}