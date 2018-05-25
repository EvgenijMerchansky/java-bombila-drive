package com.company.application.passenger.account;

import com.company.application.passenger.accountType.AccountTypeSwitcher;
import com.company.application.passenger.accountType.AccountTypesList;
import com.company.application.passenger.location.Location;
import com.company.application.passenger.order.Order;
import com.company.application.passenger.printProfile.PrintProfileData;
import com.company.application.passenger.profile.Avatar;
import com.company.application.passenger.profile.Info;
import com.company.application.passenger.profile.Name;
import com.company.application.passenger.profile.Profile;
import com.company.application.passenger.menuInfo.InfoBlock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PassengerAccount implements PassengerAccountInterface {
	private final ArrayList<Map<Integer, String>> orders = new ArrayList<>();
	private final String name;
	private final String lastname;
	private final String sex;
	private String tel;
	private String avatarUrl = "https://cdn.app.compendium.com/uploads/user/e7c690e8-6ff9-102a-ac6d-e4aebca50425/9f78fc09-faec-4068-82bd-09e7cc8bbf34/File/e19ea0216ae8395bd4b3389970928be9/java_logo.png"; // TODO: change this line no-hardcode
	private AccountTypesList accountType = AccountTypesList.BASIC;

	// TODO: change PassengerAccount instance maker to builder patern
	public PassengerAccount(String name, String lastname, String tel, String sex) {
		this.name = name;
		this.lastname = lastname;
		this.tel = tel;
		this.sex = sex;
	}

	public boolean makeProfile(boolean dataIsCorrect) {
		Scanner scanner = new Scanner(System.in);
		Profile profile = Profile
			.getBuilder()
			.setName(new Name(this.name, this.lastname))
			.setAvatar(new Avatar(this.avatarUrl))
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
		this.accountType = new AccountTypeSwitcher()
			.setAccountType(AccountTypesList.PREMIUM);
		System.out.println("profile type switched to: " + this.accountType);

		return menuHelper();
	}

	private boolean printAccountTypeSubMenu() {
		System.out.println("PassengerAccount type: " + this.accountType);

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

	/**
	 * service methods
	 */
	public void makeOrder() {
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
		setOrder(locationFrom, locationTo);


		System.out.println("Your currently order |FROM|: " + order.getFrom().getStreet() + " " + order.getFrom().getHouseNumber() + ", |TO|: " + order.getTo().getCity() + " " + order.getTo().getHouseNumber() + " accepted!");
		System.out.println("Please, wait for our call :)");
	}

	private void setOrder(Location from, Location to) {
		Map<Integer, String> subOrder = new HashMap<>();
		subOrder.put(0, from.getStreet());
		subOrder.put(1, to.getStreet());
		this.orders.add(subOrder);
	}

	public ArrayList<Map<Integer, String>> getOrders() {
		return this.orders;
	}

	/**
	 * @helpers
	 */
	public void printProfile() {

		// TODO: rebuild to builder pattern
		new PrintProfileData(
			this.name,
			this.lastname,
			this.tel,
			this.sex,
			this.accountType,
			this.avatarUrl
		).printData();
	}

	public boolean menuHelper() {
		this.makeProfile(true);
		return true;
	}
}

