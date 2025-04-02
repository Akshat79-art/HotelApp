package com.akshat.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akshat.hotel.model.Rooms;

public interface RoomRepository extends JpaRepository<Rooms, Integer> {

	Rooms findByNumber(String number);
	
	void deleteByNumber(String number);
}