package com.company.application.passenger.location.address;

import com.company.application.passenger.location.Location;

public class Address {
	private String from;
	private String to;

	Address(Location from, Location to) {
		this.from = from.getStreet();
		this.to = to.getStreet();
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}
}
