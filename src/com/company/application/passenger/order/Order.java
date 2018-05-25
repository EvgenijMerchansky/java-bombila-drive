package com.company.application.passenger.order;

import com.company.application.passenger.location.Location;

public class Order implements OrderInterface {
	private Location from;
	private Location to;

	public Order(Location from, Location to) {
		this.from = from;
		this.to = to;
	}

	public Location getFrom() {
		return from;
	}

	public Location getTo() {
		return to;
	}

	@Override
	public String toString() {
		return "From street: " + this.from.getStreet() + " (" + this.from.getHouseNumber() + ") to: " + this.to.getStreet() + " (" + this.to.getHouseNumber() + ").";
	}
}
