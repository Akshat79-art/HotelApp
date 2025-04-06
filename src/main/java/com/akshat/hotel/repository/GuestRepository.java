package com.akshat.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.akshat.hotel.model.Guests;

@Repository
public interface GuestRepository extends JpaRepository<Guests, Integer>{

	Guests findByEmail(String email);
	
	@Transactional
	void deleteByEmail(String email);
}
