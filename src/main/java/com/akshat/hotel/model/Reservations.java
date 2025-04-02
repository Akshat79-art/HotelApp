package com.akshat.hotel.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Reservations {

	@Id
	@Column(name = "RESERVATION_ID")
	private int reservationId;
	@Column(name = "ROOM_ID")
	private int roomId;
	@Column(name = "GUEST_ID")
	private int guestId;
	@Column(name = "RES_DATE")
	@Temporal(TemporalType.DATE)
	private Date resDate;
	
	public Reservations() {
		super();
	}

	public Reservations(int reservationId, int roomId, int guestId, Date resDate) {
		super();
		this.reservationId = reservationId;
		this.roomId = roomId;
		this.guestId = guestId;
		this.resDate = resDate;
	}

	@Override
	public String toString() {
		return "Reservation [reservationId=" + reservationId + ", roomId=" + roomId + ", guestId=" + guestId
				+ ", resDate=" + resDate + "]";
	}

	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getGuestId() {
		return guestId;
	}

	public void setGuestId(int guestId) {
		this.guestId = guestId;
	}

	public Date getResDate() {
		return resDate;
	}

	public void setResDate(Date resDate) {
		this.resDate = resDate;
	}

}
