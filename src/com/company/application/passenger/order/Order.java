package com.company.application.passenger.order;

import com.company.application.passenger.location.Location;
import com.company.application.passenger.money.Money;

public class Order implements OrderInterface {
	private Location from;
	private Location to;
	private int dollars;
	private int cents;


	public Order(Location from, Location to, Money money) {
		this.from = from;
		this.to = to;
		this.dollars = money.getDollars();
		this.cents = money.getCents();
	}

	public Location getFrom() {
		return from;
	}

	public Location getTo() {
		return to;
	}

	public int getDollars() {
		return dollars;
	}

	public int getCents() {
		return cents;
	}

	@Override
	public String toString() {
		return "From street: " + this.from.getStreet() + " (" + this.from.getHouseNumber() + ") to: " + this.to.getStreet() + " (" + this.to.getHouseNumber() + ").";
	}
}
