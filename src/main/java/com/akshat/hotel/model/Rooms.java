package com.akshat.hotel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rooms {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ROOM_ID")
	private int id;
	private String name;
	@Column(name = "ROOM_NUMBER")
	private String number;
	@Column(name = "BED_INFO")
	private String bedInfo;
	
	public Rooms() {
		super();
	}
	
	public Rooms(int id, String name, String number, String bedInfo) {
		super();
		this.id = id;
		this.name = name;
		this.number = number;
		this.bedInfo = bedInfo;
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", name=" + name + ", number=" + number + ", bedInfo=" + bedInfo + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getBedInfo() {
		return bedInfo;
	}

	public void setBedInfo(String bedInfo) {
		this.bedInfo = bedInfo;
	}
	
}
