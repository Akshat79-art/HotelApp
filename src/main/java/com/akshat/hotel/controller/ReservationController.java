package com.akshat.hotel.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.akshat.hotel.model.Guests;
import com.akshat.hotel.model.Reservations;
import com.akshat.hotel.model.Rooms;
import com.akshat.hotel.service.GuestService;
import com.akshat.hotel.service.ReservationService;
import com.akshat.hotel.service.RoomService;

@Component
public class ReservationController {
	
	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private RoomService roomService;
	
	@Autowired
	private GuestService guestService;
	
	public void getAllReservations() {
		List<Reservations> reservations = reservationService.getAllReservations();
		System.out.println("Lists of reservations:");
		for (Reservations reservation : reservations) {
			System.out.println(reservation);
		}
	}
	
	public void getReservationByRoomId() {
		String roomNum;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the room number you want to get reservation information.");
		roomNum = sc.nextLine();		
		Rooms room = roomService.getRoomByNumber(roomNum);
		List<Reservations> reservations = reservationService.getReservationByRoomId(room.getId());
		System.out.println("Lists of reservations:");
		for (Reservations reservation : reservations) {
			System.out.println(reservation);
		}
		
		sc.close();
	}
	
	public void getReservationByGuestId() {
		String guestEmail;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the email of the guest you want the information about.");
		guestEmail = sc.nextLine();	
		Guests guest = guestService.getGuestByEmail(guestEmail);
		List<Reservations> reservations = reservationService.getReservationByGuestId(guest.getId());
		System.out.println("Lists of reservations:");
		for (Reservations reservation : reservations) {
			System.out.println(reservation);
		}
		sc.close();
	}
	
	public void getReservationByDate() throws ParseException {
		String reservationDateInp = null;
		Date reservationDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the date of the reservation you want the information about.");
		reservationDateInp = sc.nextLine();	
		reservationDate = sdf.parse(reservationDateInp);
		List<Reservations> reservations = reservationService.getReservationByDate(reservationDate);
		System.out.println("Lists of reservations:");
		for (Reservations reservation : reservations) {
			System.out.println(reservation);
		}
		sc.close();
	}
}
