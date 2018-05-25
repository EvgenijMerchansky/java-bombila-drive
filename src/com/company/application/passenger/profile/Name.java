package com.company.application.passenger.profile;

public class Name {
	private String name;
	private String lastName;

	public Name(
		String name,
		String lastName
	) {
		this.name = name;
		this.lastName = lastName;
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	@Override
	public String toString() {
		return "Name: (" + this.name + "), Lastname: (" + this.lastName + ").";
	}
}
