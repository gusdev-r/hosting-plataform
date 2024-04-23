package com.academydevgus.hostingplataform.domain;

import jakarta.persistence.*;
import org.apache.commons.lang3.RandomStringUtils;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Long id;
    @Column(name = "room_type")
    private String roomType;
    @Column(name = "room_price")
    private BigDecimal roomPrice;
    @Column(name = "is_booked")
    private boolean isBooked = false;
    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<BookedRoom> bookedRoomList;
    @Lob
    private Blob photo;

    public Room() {
        this.bookedRoomList = new ArrayList<>();
    }

    public Room(Long id, String roomType, BigDecimal roomPrice, boolean isBooked,
                List<BookedRoom> bookedRoomList) {
        this.id = id;
        this.roomType = roomType;
        this.roomPrice = roomPrice;
        this.isBooked = isBooked;
        this.bookedRoomList = bookedRoomList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public BigDecimal getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(BigDecimal roomPrice) {
        this.roomPrice = roomPrice;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public List<BookedRoom> getBookedRoomList() {
        return bookedRoomList;
    }

    public void setBookedRoomList(List<BookedRoom> bookedRoomList) {
        this.bookedRoomList = bookedRoomList;
    }
    public void addBookings(BookedRoom bookedRoom) {
        if (bookedRoomList == null) {
            bookedRoomList = new ArrayList<>();
        }
        bookedRoomList.add(bookedRoom);
        bookedRoom.setRoom(this);
        isBooked = true;
        String bookingCode = RandomStringUtils.randomNumeric(10);
        bookedRoom.setBookingConfirmationCode(bookingCode);
    }
}
