package com.akshat.hotel;

import java.text.ParseException;
import java.util.Scanner;

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
        Boolean insideBreaker = true;
        int inpOpt, insideInpOpt;
        Scanner sc = new Scanner(System.in);
        
        do {
        	
			System.out.println("What do you want to work with?");
			System.out.println("Press 1 for guests. 2 for rooms. 3 for reservations. 4 to exit.");
			inpOpt = sc.nextInt();
			sc.nextLine();
			
			if(inpOpt < 1 || inpOpt > 4) {
				System.out.println("Enter a number between 1-4");
			}
			else if(inpOpt == 4) {
				breaker = false;
			}
			else if (inpOpt == 1) {
				
				GuestController guestController = context.getBean(GuestController.class);
				System.out.println("Press 1 for displaying all guests. Press 2 for seeing a particlar guest. Press 3 to enter register a new guest. Press 4 to update a guest. Press 5 to delete a guest. Press 6 to exit.");
				while(insideBreaker) {
					
					insideInpOpt = sc.nextInt();
					sc.nextLine();
					
					if(insideInpOpt < 1 || insideInpOpt > 6) {
						System.out.println("Enter a number between 1 - 6.");
					}
					else if(insideInpOpt == 6) {
						break;
					}
					else if(insideInpOpt == 1) {
						guestController.displayGuests();
					}
					else if(insideInpOpt == 2) {
						guestController.displayGuestByEmail();
					}
					else if(insideInpOpt == 3) {
				        try {
				        	guestController.saveGuest();
				        } catch (Exception e) {
				        	System.err.println(e);
				        	e.printStackTrace();
				        }
					}
					else if(insideInpOpt == 4) {
				        try {
				        	guestController.updateGuest();
				        } catch (Exception e) {
				        	System.err.println(e);
				        	e.printStackTrace();
				        }
					}
					else if(insideInpOpt == 5) {
						guestController.deleteGuestByEmail();
					}
				}
			}
			
			else if (inpOpt == 2) {
				
				RoomController roomController = context.getBean(RoomController.class);
				System.out.println("Press 1 for displaying all rooms. Press 2 for seeing details about a particlar room. Press 3 to register a new room. Press 4 to update a room. Press 5 to delete a room. Press 6 to exit.");
				while(insideBreaker) {
					
					insideInpOpt = sc.nextInt();
					sc.nextLine();
					
					if(insideInpOpt < 1 || insideInpOpt > 6) {
						System.out.println("Enter a number between 1 - 6.");
					}
					else if(insideInpOpt == 6) {
						break;
					}
					else if(insideInpOpt == 1) {
						roomController.displayRooms();
					}
					else if(insideInpOpt == 2) {
						roomController.displayRoom();
					}
					else if(insideInpOpt == 3) {
						try { roomController.addNewRoom(); } 
						catch (Exception e) {
							System.err.println(e); 
						 	e.printStackTrace(); 
						 }
					}
					else if(insideInpOpt == 4) {
						try { roomController.updateRoom(); } 
						catch (Exception e) {
							 System.err.println(e); 
							 e.printStackTrace(); 
						}
					}
					else if(insideInpOpt == 5) {
						roomController.deleteRoom();
					}
				}
			}
			
			else if (inpOpt == 3) {
				
				ReservationController reservationController = context.getBean(ReservationController.class);
				System.out.println("Press 1 for displaying all reservations. Press 2 for seeing a reservation based on room. Press 3 to for seeing a reservation based on guest. Press 4 to update a reservation. Press 5 to exit.");
				while(insideBreaker) {
					
					insideInpOpt = sc.nextInt();
					sc.nextLine();
					
					if(insideInpOpt < 1 || insideInpOpt > 6) {
						System.out.println("Enter a number between 1 - 6.");
					}
					else if(insideInpOpt == 5) {
						break;
					}
					else if(insideInpOpt == 1) {
						reservationController.getAllReservations();
					}
					else if(insideInpOpt == 2) {
						reservationController.getReservationByRoomId();
					}
					else if(insideInpOpt == 3) {
						reservationController.getReservationByGuestId();
					}
					else if(insideInpOpt == 4) {
				        try {
				        	reservationController.getReservationByDate();
				        } catch (ParseException e) {
							System.err.println(e);
							e.printStackTrace();
						}
					}
				}
			}
			
			sc.close();
		} while (breaker); 
        

    }
}
