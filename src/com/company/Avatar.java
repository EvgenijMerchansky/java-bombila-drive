package com.company;

class Avatar {
	private String avatarUrl;

	Avatar(String avatarUrl) {
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
