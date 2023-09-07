package com.mindhub.homebanking.dtos;

import com.mindhub.homebanking.models.Card;
import com.mindhub.homebanking.models.CardColor;
import com.mindhub.homebanking.models.CardType;
import com.mindhub.homebanking.models.Client;
import java.time.LocalDate;

public class CardDTO{
	private final long id;
	private final String cardHolder;
	private final CardType type;
	private final CardColor color;
	private final String number;
	private final int cvv;
	private final LocalDate fromDate;
	private final LocalDate thruDate;

	public CardDTO(Card card) {
		this.id = card.getId();
		this.cardHolder = card.getCardHolder();
		this.type = card.getType();
		this.color = card.getColor();
		this.number = card.getNumber();
		this.cvv = card.getCvv();
		this.fromDate = card.getFromDate();
		this.thruDate = card.getThruDate();
	}

	public long getId() {
		return id;
	}
	public String getCardHolder() {
		return cardHolder;
	}
	public CardType getType() {
		return type;
	}
	public CardColor getColor() {
		return color;
	}
	public String getNumber() {
		return number;
	}
	public int getCvv() {
		return cvv;
	}
	public LocalDate getFromDate() {
		return fromDate;
	}
	public LocalDate getThruDate() {
		return thruDate;
	}
}