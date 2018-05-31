package com.company.application.passenger.location;

import com.company.application.passenger.money.Money;

public class Location implements LocationInterface{
	private final String country;
	private final String city;
	private final String street;
	private final Integer houseNumber;
	// private final Money money;

	public String getCountry() {
		return this.country;
	} // TODO: maybe I can remove this method?

	public String getCity() {
		return this.city;
	}

	public String getStreet() {
		return this.street;
	}

	public Integer getHouseNumber() {
		return houseNumber;
	}

	private Location(Builder locationFrom) {
		this.country = locationFrom.country;
		this.city = locationFrom.city;
		this.street = locationFrom.street;
		this.houseNumber = locationFrom.houseNumber;
	}

	// TODO: rebuild with incapsulate constructor (builder)
	public static class Builder {
		private String country;
		private String city;
		private String street;
		private Integer houseNumber;

		public Builder(String country) {
			this.country = country;
		}

		public Builder setCity(String city) {
			this.city = city;
			return this;
		}

		public Builder setStreet(String street) {
			this.street = street;
			return this;
		}

		public Builder setHouseNumber(Integer houseNumber) {
			this.houseNumber = houseNumber;
			return this;
		}

		public Location build() {
			return new Location(this);
		}
	}
}
