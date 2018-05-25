package com.company.application.passenger.accountType;

public class AccountTypeSwitcher {
	private AccountTypesList type = AccountTypesList.BASIC;

	public AccountTypeSwitcher() {}

	public AccountTypesList setAccountType (AccountTypesList newType) {
		this.type = newType;

		return this.type;
	}

	public AccountTypesList getType() {
		return this.type;
	}
}
