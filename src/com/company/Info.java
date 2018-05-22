package com.company;

class Info {
	private String tel;
	private String sex;

	Info(String tel, String sex) {
		this.tel = tel;
		this.sex = sex;
	}

	public String getTel() {
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
