package com.company.application.passenger.account;

import java.util.ArrayList;
import java.util.Map;

public interface PassengerAccountInterface {
	void makeOrder();
	ArrayList<Map<Integer, String>> getOrders();
	void printProfile();
	boolean menuHelper();
}
