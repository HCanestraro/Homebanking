package com.mindhub.homebanking.dtos;

import com.mindhub.homebanking.models.Card;
import com.mindhub.homebanking.models.CardColor;
import com.mindhub.homebanking.models.CardType;
import java.time.LocalDate;

public class CardDTO {
	private long id;
	private String cardHolder;
	private CardType type;
	private CardColor color;
	private String number;
	private int cvv;
	private LocalDate thruDate;
	private LocalDate fromDate;
	
	public CardDTO() {
	}
	
	public CardDTO(Card card) {
		this.id = card.getId();
		this.cardHolder = card.getCardholder();
		this.type = card.getType();
		this.color = card.getColor();
		this.number = card.getNumber();
		this.cvv = card.getCvv();
		this.thruDate = card.getThruDate();
		this.fromDate = card.getFromDate();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public CardType getType() {
		return type;
	}
	public void setType(CardType type) {
		this.type = type;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public void setCardHolder(String cardholder) {
		this.cardHolder = cardholder;
	}
	public CardColor getColor() {
		return color;
	}
	public void setColor(CardColor color) {
		this.color = color;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	public LocalDate getThruDate() {
		return thruDate;
	}
	public void setThruDate(LocalDate thruDate) {
		this.thruDate = thruDate;
	}
	public LocalDate getFromDate() {
		return fromDate;
	}
	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}
}