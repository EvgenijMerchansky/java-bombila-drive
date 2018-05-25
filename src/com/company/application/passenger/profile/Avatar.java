package com.company.application.passenger.profile;

public class Avatar {
	private String avatarUrl;

	public Avatar(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	@Override
	public String toString() {
		return "Avatar URL: (" + this.avatarUrl + ").";
	}
}
