package com.mindhub.homebanking.services;
import com.mindhub.homebanking.dtos.ClientDTO;
import com.mindhub.homebanking.models.Client;
import org.springframework.security.core.Authentication;
import java.util.List;

public interface ClientService {
	List<ClientDTO> getClientsDTO();
	ClientDTO getClientDTO(Long id);
	ClientDTO getCurrentClientDTO(Authentication authentication);
	void register(String firstName, String lastName, String email, String password) throws Exception;
	Client findByEmail(String email);
}