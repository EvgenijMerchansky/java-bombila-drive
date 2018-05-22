package com.company;

class Location {
	private String country;
	private String city;
	private String street;
	private Integer houseNumber;

	public String getCountry() {
		return country;
	}

	public String getCity() {
		return city;
	}

	String getStreet() {
		return street;
	}

	Integer getHouseNumber() {
		return houseNumber;
	}

	private Location(Builder locationFrom) {
		this.country = locationFrom.country;
		this.city = locationFrom.city;
		this.street = locationFrom.street;
		this.houseNumber = locationFrom.houseNumber;
	}

	static class Builder {
		private String country;
		private String city;
		private String street;
		private Integer houseNumber;

		Builder(String country) {
			this.country = country;
		}

		Builder setCity(String city) {
			this.city = city;
			return this;
		}

		Builder setStreet(String street) {
			this.street = street;
			return this;
		}

		Builder setHouseNumber(Integer houseNumber) {
			this.houseNumber = houseNumber;
			return this;
		}

		Location build() {
			return new Location(this);
		}
	}
}
