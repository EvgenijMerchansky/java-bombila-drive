package com.company.application.passenger.profile;

public class Profile {
	private final Name name;
	private final Avatar avatar;
	private final Info info;

	private Profile(
		Name name,
		Avatar avatar,
		Info info
	) {
		this.name = name;
		this.avatar = avatar;
		this.info = info;
	}

	public static Builder getBuilder() {
		return new Builder();
	}

	public static class Builder {
		private Name name;
		private Avatar avatar;
		private Info info;

		public Builder setName(Name name) {
			this.name = name;
			return this;
		}

		public Builder setAvatar(Avatar avatar) {
			this.avatar = avatar;
			return this;
		}

		public Builder setInfo(Info info) {
			this.info = info;
			return this;
		}

		public Profile build() {
			return new Profile(name, avatar, info);
		}
	}
}
