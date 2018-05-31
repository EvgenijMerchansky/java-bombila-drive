package com.company.application;

import com.company.application.passenger.account.PassengerAccount;

import java.util.Scanner;

public class Passenger implements PassengerInterface {
	private void authCheck(PassengerAccount acc) {
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

	private void enableApp() {
		String appState = new Scanner(System.in).next();

		switch (appState) {
			case "/start":
				startRegister();
				return;
			case "/close":
				System.out.println("Bye!");
				return;
			case "/info":
				watchInformationList();
				return;
			default:
				getInvalidInputInfo();
		}
	}

	public void accountRegistration() {
		this.greeting();
		this.enableApp();
	}

	private void greeting() {
		System.out.println("Hi dear user! It is 'Bombila drive' taxi service! You can use console commands for creating profile and use application functionality, enjoy!");
		System.out.println("For creating profile type '/start' for close app type: '/close'");
	}

	private void startRegister() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("create name:");
		String name = scanner.next();

		System.out.println("create lastname:");
		String lastname = scanner.next();

		System.out.println("tel number(10 numbers):");
		//TODO: move this code in separate method for check validation
		long number = scanner.nextInt();

		System.out.println("gender:");
		String gender = scanner.next();

		PassengerAccount acc = new PassengerAccount(name, lastname, number, gender);
		authCheck(acc);
	}

	private void watchInformationList() {
		System.out.println("Command list:");
		System.out.println("1. For create profile type: '/start'");
		System.out.println("2. For close application type: '/close'");
		System.out.println("3. Read commands list: '/info'");
		enableApp();
	}

	private void getInvalidInputInfo() {
		System.out.println("Sorry you typed unknown command :(");
		System.out.println("Type '/info' for help");
		System.out.println("----------------------------------");
		enableApp();
	}
}
