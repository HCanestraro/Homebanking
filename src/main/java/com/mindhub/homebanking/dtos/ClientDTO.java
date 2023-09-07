package com.mindhub.homebanking.dtos;

import com.mindhub.homebanking.models.Client;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.HashSet;

public class ClientDTO {
    private final Long id;
    private final String email;
    private final String firstName;
    private final String lastName;
    private Set<AccountDTO> accounts = new HashSet<>();
    private Set<ClientLoanDTO> loans = new HashSet<>();
    private Set<CardDTO> cards = new HashSet<>();

    public ClientDTO(Client client) {
        this.id = client.getId();
        this.email = client.getEmail();
        this.firstName = client.getFirstName();
        this.lastName = client.getLastName();

        this.accounts = client.getAccounts().stream().map(AccountDTO::new).collect(Collectors.toSet());
        this.loans = client.getClientLoans().stream().map(ClientLoanDTO::new).collect(Collectors.toSet());
        this.cards = client.getCards().stream().map(CardDTO::new).collect(Collectors.toSet());
        }
        public Long getId() {
            return id;
        }
        public String getEmail() {
            return email;
        }
        public String getFirstName() {
            return firstName;
        }
        public String getLastName() {
            return lastName;
        }
        public Set<AccountDTO> getAccounts() {
            return accounts;
        }
        public Set<ClientLoanDTO> getLoans() {
            return loans;
        }
        public Set<CardDTO> getCards() {
            return cards;
        }
    }