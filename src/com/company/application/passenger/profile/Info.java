package com.company.application.passenger.profile;

public class Info {
	private long tel;
	private String sex;

	public Info(long tel, String sex) {
		this.tel = tel;
		this.sex = sex;
	}

	public long getTel() {
		return tel;
	}

	public String getSex() {
		return sex;
	}

	@Override
	public String toString() {
		return "User information: " +
			"tel:(" + this.tel + "), sex: (" + this.sex + ").";
	}
}
