package com.company.application.passenger.printProfile;

import com.company.application.passenger.accountType.AccountTypesList;

public class PrintProfileData {
	private final String name;
	private final AccountTypesList accountType;
	private final String lastname;
	private final String tel;
	private final String sex;
	private final String avatarUrl;

	// TODO: rebuild to builder pattern
	public PrintProfileData(
		String name,
		String lastname,
		String tel,
		String sex,
		AccountTypesList accountType,
		String avatarUrl
	) {
		this.name = name;
		this.lastname = lastname;
		this.tel = tel;
		this.sex = sex;
		this.accountType = accountType;
		this.avatarUrl = avatarUrl;
	}

	public void printData() {
		System.out.println("-----------PROFILE----------");
		System.out.println("Name: " + this.name);
		System.out.println("Lastname: " + this.lastname);
		System.out.println("Phone number: " + this.tel);
		System.out.println("Gender: " + this.sex);
		System.out.println("Avatar: " + this.avatarUrl);
		System.out.println("PassengerAccount type: " + this.accountType);
		System.out.println("----------------------------");
	}
}
