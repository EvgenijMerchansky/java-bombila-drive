package com.company;

import java.util.Scanner;

class Passenger {

	private void authChecked(Account acc) {
		if (!acc.makeProfile(true)) {
			this.greeting();
			enableApp();
		} else {
			System.out.println("logged out!");
			System.out.println("-----------");
			this.greeting();
			enableApp();
		}
	}

	private void greeting() {
		System.out.println("Hi dear user! It is 'Bombilla drive' taxi service! You can use console commands for creating profile and use application functionality, enjoy!");
		System.out.println("For creating profile type '/start' for close app type: '/close'");
	}

	void accountRegistration() {
		this.greeting();
		this.enableApp();
	}

	private void enableApp() {
		Scanner scanner = new Scanner(System.in);
		String appState = scanner.next();

		switch (appState) {
			case "/start":
				System.out.println("create name:");
				String name = scanner.next();

				System.out.println("create lastname:");
				String lastname = scanner.next();

				System.out.println("tel number:");
				String number = scanner.next();

				System.out.println("gender:");
				String gender = scanner.next();

				Account acc = new Account(name, lastname, number, gender);
				authChecked(acc);

				return;
			case "/close":
				System.out.println("Bye!");
				return;
			case "/info":
				System.out.println("Command list:");
				System.out.println("1. For create profile type: '/start'");
				System.out.println("2. For close application type: '/close'");
				System.out.println("3. Read commands list: '/info'");
				enableApp();
				return;
			default:
				System.out.println("Sorry you typed unknown command :(");
				System.out.println("Type '/info' for help");
				System.out.println("----------------------------------");
				enableApp();
		}
	}
}
