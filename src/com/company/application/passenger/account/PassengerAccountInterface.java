package com.company.application.passenger.account;

import java.util.ArrayList;
import java.util.Map;

public interface PassengerAccountInterface {
	void makeOrder();
	void printProfile();
	boolean menuHelper();
	ArrayList<Map<Integer, String>> getOrders();
}
