package com.mindhub.homebanking.controllers;

import com.mindhub.homebanking.dtos.AccountDTO;
import com.mindhub.homebanking.dtos.CardDTO;
import com.mindhub.homebanking.models.Card;
import com.mindhub.homebanking.models.CardColor;
import com.mindhub.homebanking.models.CardType;
import com.mindhub.homebanking.models.Client;
import com.mindhub.homebanking.repositories.CardRepository;
import com.mindhub.homebanking.repositories.ClientRepository;
import com.mindhub.homebanking.services.CardService;
import com.mindhub.homebanking.services.ClientService;
import com.mindhub.homebanking.repositories.AccountRepository;
import com.mindhub.homebanking.repositories.ClientLoanRepository;
import com.mindhub.homebanking.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import java.util.concurrent.CancellationException;
import static com.mindhub.homebanking.models.CardType.CREDIT;
import static com.mindhub.homebanking.models.CardType.DEBIT;
import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api")
public class CardController {
	@Autowired
	private CardService cardService;
	@Autowired
	private ClientService clientService;
	@RequestMapping("/clients/current/cards")
	public List<CardDTO> findCard(Authentication authentication) {
		return cardService.findByClient(clientService.findByEmail(authentication.getName())).stream().map(CardDTO::new).collect(toList());
	}
	
	@RequestMapping(path = "/clients/current/cards", method = RequestMethod.POST)
	public ResponseEntity<Object> create(@RequestParam CardColor cardColor,
	                                     @RequestParam CardType cardType,
	                                     Authentication authentication, String number, Integer cvv) {
		Client client = clientService.findByEmail(authentication.getName());
		String name = clientService.findByEmail(authentication.getName()).getFirstName() + " " + clientService.findByEmail(authentication.getName()).getLastName();
		List<Card> cardsByClient = cardService.findByClient(client);
		
		int contC=0;
		int contD=0;
		for(int i=0; i<cardsByClient.size(); i++) {
			if(cardsByClient.get(i).getType().equals(CREDIT)) {
				contC++;
			}
			if(cardsByClient.get(i).getType().equals(DEBIT)) {
				contD++;
			}
		}
		if (cardsByClient.size() < 7) {
			if (contD<3&&cardType.equals(DEBIT)) {
				Card card = new Card(client, name, DEBIT, cardColor, number, cvv, LocalDate.now().plusYears(5), LocalDate.now());
				cardService.save(card);
				return new ResponseEntity<>(HttpStatus.CREATED);
			}
			if (cardType.equals(CREDIT) && contC < 3) {
				Card card = new Card(client, name, CREDIT, cardColor, number, cvv, LocalDate.now().plusYears(5), LocalDate.now());
				cardService.save(card);
				return new ResponseEntity<>(HttpStatus.CREATED);
			}
		} else {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}
}