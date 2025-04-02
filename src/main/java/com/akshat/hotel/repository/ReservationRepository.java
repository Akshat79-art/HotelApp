package com.akshat.hotel.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akshat.hotel.model.Reservations;

@Repository
public interface ReservationRepository extends JpaRepository<Reservations, Integer> {

	List<Reservations> findByRoomId(int roomId);
	
	List<Reservations> findByGuestId(int guestId);
	
	List<Reservations> findByDate(Date date);
}
