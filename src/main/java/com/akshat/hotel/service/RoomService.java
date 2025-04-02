package com.akshat.hotel.service;

import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akshat.hotel.model.Rooms;
import com.akshat.hotel.repository.RoomRepository;

@Service
public class RoomService {

	@Autowired
	private RoomRepository roomRepository;
	
	public List<Rooms> getAllRooms(){
		return roomRepository.findAll();
	}
	
	public Rooms getRoomById(int id) {
		return roomRepository.findById(id).orElse(null);
	}
	
	public Rooms getRoomByNumber(String roomNumber) {
		return roomRepository.findByNumber(roomNumber);
	}

	public int updateRoom(String roomNumber, HashMap<String, String> updatePropertyValue) throws Exception{
		Rooms roomToUpdate = getRoomByNumber(roomNumber);
		for(Map.Entry<String, String> map: updatePropertyValue.entrySet()) {
			PropertyDescriptor pd = new PropertyDescriptor(map.getKey(), roomToUpdate.getClass());
			pd.getWriteMethod().invoke(roomToUpdate, map.getValue());
		}
		roomRepository.save(roomToUpdate);
		return 0;
	}
	
	public int saveNewRoom(HashMap<String, String> roomDetails) throws Exception{
		Rooms newRoom = new Rooms();
		for(Map.Entry<String, String> map: roomDetails.entrySet()) {
			PropertyDescriptor pd = new PropertyDescriptor(map.getKey(), newRoom.getClass());
			pd.getWriteMethod().invoke(newRoom, map.getValue());
		}
		roomRepository.save(newRoom);
		return 1;
	}
	
	public void deleteRoomByNumber(String roomNumber) {
//		Rooms room = getRoomByNumber(roomNumber);
//		roomRepository.delete(room);
		roomRepository.deleteByNumber(roomNumber);
	}
}