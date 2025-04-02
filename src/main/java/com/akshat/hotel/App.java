package com.akshat.hotel;

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
        GuestController guestController = context.getBean(GuestController.class);
//        guestController.displayGuests();
        guestController.displayGuestById();
        
        RoomController roomController = context.getBean(RoomController.class);
//        roomController.displayRooms();
        roomController.displayRoom(1);
        
        ReservationController reservationController = context.getBean(ReservationController.class);
//        reservationController.getAllReservations();
        reservationController.getReservationByRoomId();
    }
}
