package com.mindhub.homebanking.services;

import com.mindhub.homebanking.models.Client;
import com.mindhub.homebanking.dtos.ClientDTO;
import java.util.Optional;
import java.util.List;

public interface ClientService {
	Client findByEmail(String email);
	List<Client> findAll();
	Client findById(long id);
	void save(Client client);
}