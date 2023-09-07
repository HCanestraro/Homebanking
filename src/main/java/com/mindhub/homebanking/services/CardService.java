package com.mindhub.homebanking.services;
import com.mindhub.homebanking.models.CardColor;
import com.mindhub.homebanking.models.CardType;
import org.springframework.security.core.Authentication;

public interface CardService {
	void createCard(Authentication authentication, CardType cardType, CardColor cardColor) throws Exception;
}
