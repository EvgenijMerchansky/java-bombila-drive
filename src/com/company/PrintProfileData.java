package com.company;

import com.company.accountType.AccountTypesList;

class PrintProfileData {

	private String name;
	private AccountTypesList accountType;
	private String lastname;
	private String tel;
	private String sex;
	private String avatarUrl;

	PrintProfileData(

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

	void printData() {
		System.out.println("-----------PROFILE----------");
		System.out.println("Name: " + this.name);
		System.out.println("Lastname: " + this.lastname);
		System.out.println("Phone number: " + this.tel);
		System.out.println("Gender: " + this.sex);
		System.out.println("Avatar: " + this.avatarUrl);
		System.out.println("Account type: " + this.accountType);
		System.out.println("----------------------------");
	}
}
