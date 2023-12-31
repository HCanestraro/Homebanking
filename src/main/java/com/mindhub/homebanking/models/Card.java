package com.mindhub.homebanking.models;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Card {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private long id;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="client_id")
	private Client client;
	private String cardHolder;
	private CardType type;
	private CardColor color;
	private Integer cvv;
	private LocalDate thruDate;
	private LocalDate fromDate;
	private String number;
	public Card() {
	}
	Integer cardNumber1 = (int) Math.floor(Math.random()*Math.max(1, 10000));
	Integer cardNumber2 = (int) Math.floor(Math.random()*Math.max(1, 10000));
	Integer cardNumber3 = (int) Math.floor(Math.random()*Math.max(1, 10000));
	Integer cardNumber4 = (int) Math.floor(Math.random()*Math.max(1, 10000));
	
	public Card(Client client, String cardholder, CardType type, CardColor color, String number, Integer cvv, LocalDate thruDate, LocalDate fromDate) {
		this.client= client;
		this.cardHolder = cardholder;
		this.type = type;
		this.color = color;
		this.number =cardNumber1.toString()+"-"+cardNumber2.toString()+"-"+cardNumber3.toString()+"-"+cardNumber4.toString();
		this.cvv =(int) Math.floor(Math.random()*Math.max(1, 1000));
		this.thruDate = thruDate;
		this.fromDate = fromDate;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCardholder() {
		return cardHolder;
	}
	public void setCardholder(String cardholder) {
		this.cardHolder = cardholder;
	}
	public CardType getType() {
		return type;
	}
	public void setType(CardType type) {
		this.type = type;
	}
	public CardColor getColor() {
		return color;
	}
	public void setColor(CardColor color) {
		this.color = color;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
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
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
}