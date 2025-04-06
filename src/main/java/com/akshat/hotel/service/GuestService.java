package com.akshat.hotel.service;

import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akshat.hotel.model.Guests;
import com.akshat.hotel.repository.GuestRepository;

@Service
public class GuestService {

	@Autowired
	private GuestRepository guestRepository;
	
	public List<Guests> getAllGuests(){
		return guestRepository.findAll();
	}
	
	public Guests getGuestById(int id) {
		return guestRepository.findById(id).orElse(null);
	}
	
	public Guests getGuestByEmail(String email) {
//		List<Guests> guests = getAllGuests();
//		for (Guests guest : guests) {
//			if(guest.getEmail().equals(email)) {
//				return guest;
//			}
//		}
//		return null;
		return guestRepository.findByEmail(email);
	}
	
	public int updateGuest(String email, HashMap<String, String> updatePropertyValue) throws Exception{
		Guests guestToUpdate = getGuestByEmail(email);
		for(Map.Entry<String, String> map: updatePropertyValue.entrySet()) {
			PropertyDescriptor pd = new PropertyDescriptor(map.getKey(), guestToUpdate.getClass());
			pd.getWriteMethod().invoke(guestToUpdate, map.getValue());
		}
		guestRepository.save(guestToUpdate);
		return 0;
	}
	
	public void saveGuest(HashMap<String, String> guestDetails) throws Exception{
		Guests newGuest = new Guests();
		for(Map.Entry<String, String> map: guestDetails.entrySet()) {
			PropertyDescriptor pd = new PropertyDescriptor(map.getKey(), newGuest.getClass());
			pd.getWriteMethod().invoke(newGuest, map.getValue());
		}
		guestRepository.save(newGuest);
	}
	
	public void deleteGuestById(int id) {
		guestRepository.deleteById(id);
	}
	
	public void deleteGuestByEmail(String email) {
		guestRepository.deleteByEmail(email);
	}
	
}
