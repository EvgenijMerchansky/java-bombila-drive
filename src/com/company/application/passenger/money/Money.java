package com.company.application.passenger.money;

public class Money {
	private int dollars;
	private int cents;

	public Money(int dollars, int cents) {
		this.dollars = dollars;
		this.cents = cents;
	}

	public int getDollars() {
		return dollars;
	}

	public int getCents() {
		return cents;
	}
}
