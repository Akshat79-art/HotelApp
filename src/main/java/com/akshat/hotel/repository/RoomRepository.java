package com.akshat.hotel.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akshat.hotel.model.Rooms;

public interface RoomRepository extends JpaRepository<Rooms, Integer> {

	Rooms findByNumber(String number);
	
	@Transactional
	void deleteByNumber(String number);
}