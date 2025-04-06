package com.akshat.hotel;

import java.text.ParseException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.akshat.hotel.controller.GuestController;
import com.akshat.hotel.controller.ReservationController;
import com.akshat.hotel.controller.RoomController;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Boolean breaker = true;
        
        GuestController guestController = context.getBean(GuestController.class);
        do {
			
		} while (breaker);
//        guestController.displayGuests();
//        guestController.displayGuestByEmail();
//        try {
//			guestController.saveGuest();
//		} catch (Exception e) {
//			System.err.println(e);
//			e.printStackTrace();
//		}
//        try {
//			guestController.updateGuest();
//		} catch (Exception e) {
//			System.err.println(e);
//			e.printStackTrace();
//		}
        guestController.deleteGuestByEmail();
        
        RoomController roomController = context.getBean(RoomController.class);
//        roomController.displayRooms();
//        roomController.displayRoom("1");
		/*
		 * try { roomController.addNewRoom(); } catch (Exception e) {
		 * System.err.println(e); e.printStackTrace(); }
		 */
		
//		 try { roomController.updateRoom(); } catch (Exception e) {
//		  System.err.println(e); e.printStackTrace(); }
		 
//        roomController.deleteRoom();
        
        ReservationController reservationController = context.getBean(ReservationController.class);
//        reservationController.getAllReservations();
//        reservationController.getReservationByRoomId();//working
//        reservationController.getReservationByGuestId(); // working
//        try {
//			reservationController.getReservationByDate();
//		} catch (ParseException e) {
//			System.err.println(e);
//			e.printStackTrace();
//		}
    }
}
