package com.akshat.hotel.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.akshat.hotel.model.Guests;
import com.akshat.hotel.service.GuestService;

@Component
public class GuestController {

	@Autowired
	private GuestService guestService;
	
	public void displayGuests(){
		List<Guests> guests = guestService.getAllGuests();
		System.out.println("Lists of guests:");
		for (Guests guest : guests) {
			System.out.println(guest);
		}
	}
	
	public void displayGuestById() {
		int guestId;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id of the guest you want to get details of.");
		guestId = sc.nextInt();
		sc.close();
		Guests guest = guestService.getGuestById(guestId);
		if (guest != null) {
			System.out.println("Guest:" + guest);
		} else {
			System.out.println("No Guest found.");
		}
	}
	
	public void displayGuestByEmail() {
		String guestEmail;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the email of the guest you want to get details of.");
		guestEmail = sc.nextLine();
		sc.close();
		Guests guest = guestService.getGuestByEmail(guestEmail);
		if (guest != null) {
			System.out.println("Guest:" + guest);
		} else {
			System.out.println("No Guest found.");
		}
	}
	
	public void updateGuest() throws Exception {
		int optionNum;
		String guestMail = "";
		String updatedValue;
		Guests guest;
		HashMap<String, String> updatedValues = new HashMap<String, String>();
		boolean breaker = true;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter email of the guest you want to update:");
		guestMail = sc.nextLine();
		guest = guestService.getGuestByEmail(guestMail);
		if (guest != null) {
			do {
				System.out.println("Which properties do you want to update?");
				System.out.println("Type 1 for updating firstname.");
				System.out.println("Type 2 for updating lastname.");
				System.out.println("Type 3 for updating email.");
				System.out.println("Type 4 for updating address.");
				System.out.println("Type 5 for updating country.");
				System.out.println("Type 6 for updating state.");
				System.out.println("Type 7 for updating phone number.");
				System.out.println("Type 8 for exiting.");
				optionNum = sc.nextInt();
				sc.nextLine();
				if(optionNum < 1 || optionNum > 8) {
					System.out.println("Enter a number between 1-8.");
					continue;
				} else if (optionNum == 8) {
					breaker = false;
				} else {
					System.out.println("Enter the value to update:");
					updatedValue = sc.nextLine();
					if(optionNum == 1) {
						if(updatedValues.containsKey("firstName")) {
							updatedValues.replace("firstName", updatedValue);
						} else {
							updatedValues.put("firstName", updatedValue);
						}
					} else if(optionNum == 2) {
						if(updatedValues.containsKey("lastName")) {
							updatedValues.replace("lastName", updatedValue);
						} else {
							updatedValues.put("lastName", updatedValue);
						}
					} else if(optionNum == 3) {
						if(updatedValues.containsKey("email")) {
							updatedValues.replace("email", updatedValue);
						} else {
							updatedValues.put("email", updatedValue);
						}
					} else if(optionNum == 4) {
						if(updatedValues.containsKey("address")) {
							updatedValues.replace("address", updatedValue);
						} else {
							updatedValues.put("address", updatedValue);
						}
					} else if(optionNum == 5) {
						if(updatedValues.containsKey("country")) {
							updatedValues.replace("country", updatedValue);
						} else {
							updatedValues.put("country", updatedValue);
						}
					} else if(optionNum == 6) {
						if(updatedValues.containsKey("state")) {
							updatedValues.replace("state", updatedValue);
						} else {
							updatedValues.put("state", updatedValue);
						}
					} else if(optionNum == 7) {
						if(updatedValues.containsKey("phoneNum")) {
							updatedValues.replace("phoneNum", updatedValue);
						} else {
							updatedValues.put("phoneNum", updatedValue);
						}
					} 	
				}
			} while(breaker == true);
		}
		sc.close();
		guestService.updateGuest(guestMail, updatedValues);
	}
	
	public void saveGuest() throws Exception {
		String inputValue;
		HashMap<String, String> guestDetails = new HashMap<String, String>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter details of guest as prompted. Enter exit to exit at anytime.");
		System.out.println("Enter first name of the guest:");
		inputValue = sc.nextLine();
		if(inputValue.equals("exit")) {
			sc.close();
			return;
		} else {
			guestDetails.put("firstName", inputValue);
		}
		System.out.println("Enter last name of the guest:");
		inputValue = sc.nextLine();
		if(inputValue.equals("exit")) {
			sc.close();
			return;
		} else {
			guestDetails.put("lastName", inputValue);
		}
		System.out.println("Enter email of the guest:");
		inputValue = sc.nextLine();
		if(inputValue.equals("exit")) {
			sc.close();
			return;
		} else {
			guestDetails.put("email", inputValue);
		}
		System.out.println("Enter address of the guest:");
		inputValue = sc.nextLine();
		if(inputValue.equals("exit")) {
			sc.close();
			return;
		} else {
			guestDetails.put("address", inputValue);
		}
		System.out.println("Enter country of the guest:");
		inputValue = sc.nextLine();
		if(inputValue.equals("exit")) {
			sc.close();
			return;
		} else {
			guestDetails.put("country", inputValue);
		}
		System.out.println("Enter state of the guest:");
		inputValue = sc.nextLine();
		if(inputValue.equals("exit")) {
			sc.close();
			return;
		} else {
			guestDetails.put("state", inputValue);
		}
		System.out.println("Enter phone number of the guest:");
		inputValue = sc.nextLine();
		if(inputValue.equals("exit")) {
			sc.close();
			return;
		} else {
			guestDetails.put("phoneNum", inputValue);
		}
		sc.close();
		guestService.saveGuest(guestDetails);
	}
	
	public void deleteGuestById() {
		int guestId;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id of the guest you want to get details of.");
		guestId = sc.nextInt();
		sc.close();
		guestService.deleteGuestById(guestId);
	}
	
	public void deleteGuestByEmail() {
		String guestEmail;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the email of the guest you want to get details of.");
		guestEmail = sc.nextLine();
		sc.close();
		guestService.deleteGuestByEmail(guestEmail);
	}
}
