package com.akshat.hotel.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.akshat.hotel.model.Rooms;
import com.akshat.hotel.service.RoomService;

@Component
public class RoomController {

	@Autowired
	private RoomService roomService;
	
	public void displayRooms(){
		List<Rooms> rooms = roomService.getAllRooms();
		System.out.println("Lists of guests:");
		for (Rooms room : rooms) {
			System.out.println(room);
		}
	}
	
	public void displayRoom(int id) {
		Rooms room = roomService.getRoomById(id);
		if (room != null) {
			System.out.println("Room:" + room);
		}
		else {
			System.out.println("No room with this id.");
		}
	}

	public void displayRoom() {
		String roomNum;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of the room you want to get details of.");
		roomNum = sc.nextLine();
		sc.close();
		Rooms room = roomService.getRoomByNumber(roomNum);
		if (room != null) {
			System.out.println("Room:" + room);
		}
		else {
			System.out.println("No room with this id.");
		}
	}
	
	public void updateRoom() throws Exception {
	    String roomNumber, updatedValue;
	    int optionNum;
	    HashMap<String, String> updatedValues = new HashMap<String, String>();
	    boolean breaker = true;
	    Scanner sc = new Scanner(System.in);
	    
	    System.out.println("Which room do you want to update?");
	    roomNumber = sc.nextLine();
	    
	    Rooms room = roomService.getRoomByNumber(roomNumber);
	    
	    if (room != null) {
	        do {
	            System.out.println("Which properties do you want to update?");
	            System.out.println("Type 1 for updating name.");
	            System.out.println("Type 2 for updating number.");
	            System.out.println("Type 3 for updating bed info.");
	            System.out.println("Type 4 for exiting.");
	            
	            optionNum = sc.nextInt();
	            sc.nextLine();
	            
	            if (optionNum < 1 || optionNum > 4) {
	                System.out.println("Enter a number between 1-4.");
	                continue;
	            } else if (optionNum == 4) {
	                breaker = false;
	            } else {
	                System.out.println("Enter the value to update:");
	                updatedValue = sc.nextLine();
	                
	                switch (optionNum) {
	                    case 1:
	                        updatedValues.put("name", updatedValue);
	                        break;
	                    case 2:
	                        updatedValues.put("number", updatedValue);
	                        break;
	                    case 3:
	                        updatedValues.put("bedInfo", updatedValue);
	                        break;
	                }
	            }
	        } while (breaker);
	    }	    
	    roomService.updateRoom(roomNumber, updatedValues);
	    sc.close();
	}

	public void addNewRoom() throws Exception {
		String inputValue;
	    HashMap<String, String> roomDetails = new HashMap<String, String>();
	    Scanner sc = new Scanner(System.in);
	    
	    System.out.println("Enter details of guest as prompted. Enter exit to exit at anytime.");
	    
	    System.out.println("Enter name of the room:");
		inputValue = sc.nextLine();
		if(inputValue.equals("exit")) {
			sc.close();
			return;
		} else {
			roomDetails.put("name", inputValue);
		}
		System.out.println("Enter number of the room:");
		inputValue = sc.nextLine();
		if(inputValue.equals("exit")) {
			sc.close();
			return;
		} else {
			roomDetails.put("number", inputValue);
		}
		System.out.println("Enter bed information of the room:");
		inputValue = sc.nextLine();
		if(inputValue.equals("exit")) {
			sc.close();
			return;
		} else {
			roomDetails.put("bedInfo", inputValue);
		}
	   
	    roomService.saveNewRoom(roomDetails);
	    sc.close();
	}
	
	public void deleteRoom() {
		String roomNum;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the room number of the room you want to delete.");
		roomNum = sc.nextLine();
		roomService.deleteRoomByNumber(roomNum);
		sc.close();
	}
}