package com.mindhub.homebanking.services;

import com.mindhub.homebanking.models.Client;
import java.util.List;

public interface ClientService {
	Client findByEmail(String email);
	List<Client> findAll();
	Client findById(long id);
	void save(Client client);
}