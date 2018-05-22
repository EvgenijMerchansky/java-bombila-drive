package com.company;

import com.company.accountType.AccountTypeSwitcher;
import com.company.accountType.AccountTypesList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Account {
	private String name;
	private String lastname;
	private String tel;
	private String sex;
	private String avatarUrl = "https://cdn.app.compendium.com/uploads/user/e7c690e8-6ff9-102a-ac6d-e4aebca50425/9f78fc09-faec-4068-82bd-09e7cc8bbf34/File/e19ea0216ae8395bd4b3389970928be9/java_logo.png";
	private AccountTypesList accountType = AccountTypesList.BASIC;
	private ArrayList<Map<Integer, String>> orders = new ArrayList<>();

	Account(String name, String lastname, String tel, String sex) {
		this.name = name;
		this.lastname = lastname;
		this.tel = tel;
		this.sex = sex;
	}

	private void printProfile() {
		new PrintProfileData(
			this.name,
			this.lastname,
			this.tel,
			this.sex,
			this.accountType,
			this.avatarUrl
		).printData();
	}

	boolean makeProfile(boolean dataIsCorrect) {
		Scanner scanner = new Scanner(System.in);
		Profile profile = new Profile
			.Builder(new Name(this.name, this.lastname))
			.setAvatar(new Avatar(this.avatarUrl)) // default
			.setInfo(new Info(this.tel, this.sex))
			.build();

		if (dataIsCorrect) {
			new InfoBlock().runInfoBlock();
			String dashboardNavigation = scanner.next();

			switch (dashboardNavigation) {
				case "/order":
					return printOrderSubMenu();
				case "/orders":
					return printOrdersSubMenu();
				case "/changeNumber":
					return printChangeNumberSubMenu();
				case "/changeAvatar":
					return printChangeAvatarSubMenu();
				case "/accountType":
					return printAccountTypeSubMenu();
				case "/profileInfo":
					return printProfileSubMenu();
				case "/switchAccountType":
					return printAccountTypeSwitchSubMenu();
				case "/exit":
					return false;
				default:
					return menuHelper();
			}
		}
		return false;
	}

	private boolean printProfileSubMenu() {
		printProfile();

		return menuHelper();
	}

	private boolean printAccountTypeSwitchSubMenu() {
		this.accountType = new AccountTypeSwitcher().setAccountType(AccountTypesList.PREMIUM);
		System.out.println("account type switched to: " + this.accountType);

		return menuHelper();
	}

	private boolean printAccountTypeSubMenu() {
		System.out.println("Account type: " + this.accountType);

		return menuHelper();
	}

	private boolean printOrderSubMenu() {
		makeOrder();

		return menuHelper();
	}

	private boolean printOrdersSubMenu() {
		System.out.println("Orders:");
		System.out.println(this.getOrders());

		return menuHelper();
	}

	private boolean printChangeNumberSubMenu() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Type new number:");
		this.tel = scanner.next();

		return menuHelper();
	}

	private boolean printChangeAvatarSubMenu() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Paste new avatar URL:");
		this.avatarUrl = scanner.next();

		return menuHelper();
	}

	private void setOrders(Location from, Location to) {
		Map<Integer, String> subOrder = new HashMap<>();
		subOrder.put(0, from.getStreet());
		subOrder.put(1, to.getStreet());
		this.orders.add(subOrder);
	}

	private ArrayList<Map<Integer, String>> getOrders() {
		return this.orders;
	}

	private boolean menuHelper() {
		makeProfile(true);
		return true;
	}

	private void makeOrder() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("|FROM| Type street:");
		String from = scanner.next();

		System.out.println("|FROM| House number:");
		int fromHouseNumber = scanner.nextInt();

		System.out.println("|TO| Type street:");
		String to = scanner.next();

		System.out.println("|TO| House number:");
		int toHouseNumber = scanner.nextInt();

		Location locationFrom = new Location
			.Builder("Ukraine")
			.setCity("Kharkiv")
			.setStreet(from)
			.setHouseNumber(fromHouseNumber)
			.build();

		Location locationTo = new Location
			.Builder("Ukraine")
			.setCity("Kharkiv")
			.setStreet(to)
			.setHouseNumber(toHouseNumber)
			.build();

		Order order = new Order(locationFrom, locationTo);
		setOrders(locationFrom, locationTo);

		System.out.println("Your currently order |FROM|: " + order.getFrom().getStreet() + " " + order.getFrom().getHouseNumber() + ", |TO|: " + order.getTo().getCity() + " " + order.getTo().getHouseNumber() + " accepted!");
		System.out.println("Please, wait for our call :)");
	}
}

