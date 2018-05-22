package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Order {
	private Location from;
	private Location to;

	Order(Location from, Location to) {
		this.from = from;
		this.to = to;
	}

	public Location getFrom() {
		return from;
	}

	public Location getTo() {
		return to;
	}

	@Override
	public String toString() {
		return "From street: " + this.from.getStreet() + " (" + this.from.getHouseNumber() + ") to: " + this.to.getStreet() + " (" + this.to.getHouseNumber() + ").";
	}
}

/**
 *
 */
class History {
	private ArrayList<Map<Integer, String>> orders = new ArrayList<>();

	History() {}

	ArrayList<Map<Integer, String>> setHistory(Location from, Location to) {
		Map<Integer, String> subOrder = new HashMap<>();
		subOrder.put(0, from.getStreet());
		subOrder.put(1, to.getStreet());
		this.orders.add(subOrder);

		return this.orders;
	}

	ArrayList<Map<Integer, String>> getHistory() {
		return this.orders;
	}
}
/**
 *
 */

class Profile {
	private Name name;
	private Avatar avatar;
	private Info info;

	Name getName() {
		return name;
	}

	Avatar getAvatar() {
		return avatar;
	}

	Info getInfo() {
		return info;
	}

	private Profile(Builder builder) {
		this.name = builder.name;
		this.avatar = builder.avatar;
		this.info = builder.info;
	}

	static class Builder {
		private Name name;
		private Avatar avatar;
		private Info info;

		Builder (Name name) {
			this.name = name;
		}

		Builder setAvatar(Avatar avatar) {
			this.avatar = avatar;
			return this;
		}

		Builder setInfo(Info info) {
			this.info = info;
			return this;
		}

		Profile build () {
			return new Profile(this);
		}
	}


}
