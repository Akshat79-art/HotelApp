package com.akshat.hotel.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akshat.hotel.model.Reservations;
import com.akshat.hotel.repository.ReservationRepository;

@Service
public class ReservationService {

	@Autowired
	private ReservationRepository reservationRepository;
	
	public List<Reservations> getAllReservations(){
		return reservationRepository.findAll();
	}
	
	public List<Reservations> getReservationByRoomId(int roomId) {
		return reservationRepository.findByRoomId(roomId);
	}
	
	public List<Reservations> getReservationByGuestId(int guestId) {
		return reservationRepository.findByGuestId(guestId);
	}
	
	public List<Reservations> getReservationByDate(Date date) {
		return reservationRepository.findByDate(date);
	}
}
