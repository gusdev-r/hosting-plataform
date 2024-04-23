package com.academydevgus.hostingplataform.dto.response;

import com.academydevgus.hostingplataform.domain.Room;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;
import java.util.Objects;

public class BookedRoomResponse {
    private Long bookingId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private String guestFullName;
    private String guestEmail;
    private int numOfAdults;
    private int numOfChildren;
    private int totalNumOfGuest;
    private String bookingConfirmationCode;
    private Room room;

    public BookedRoomResponse(Long bookingId, LocalDate checkInDate, LocalDate checkOutDate,
                              String bookingConfirmationCode) {
        this.bookingId = bookingId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.bookingConfirmationCode = bookingConfirmationCode;
    }

    public BookedRoomResponse(Long bookingId, LocalDate checkInDate, LocalDate checkOutDate,
                              String guestFullName, String guestEmail, int numOfAdults, int numOfChildren,
                              int totalNumOfGuest, String bookingConfirmationCode, Room room) {
        this.bookingId = bookingId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.guestFullName = guestFullName;
        this.guestEmail = guestEmail;
        this.numOfAdults = numOfAdults;
        this.numOfChildren = numOfChildren;
        this.totalNumOfGuest = totalNumOfGuest;
        this.bookingConfirmationCode = bookingConfirmationCode;
        this.room = room;
    }

    public BookedRoomResponse() {
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getGuestFullName() {
        return guestFullName;
    }

    public void setGuestFullName(String guestFullName) {
        this.guestFullName = guestFullName;
    }

    public String getGuestEmail() {
        return guestEmail;
    }

    public void setGuestEmail(String guestEmail) {
        this.guestEmail = guestEmail;
    }

    public int getNumOfAdults() {
        return numOfAdults;
    }

    public void setNumOfAdults(int numOfAdults) {
        this.numOfAdults = numOfAdults;
    }

    public int getNumOfChildren() {
        return numOfChildren;
    }

    public void setNumOfChildren(int numOfChildren) {
        this.numOfChildren = numOfChildren;
    }

    public int getTotalNumOfGuest() {
        return totalNumOfGuest;
    }

    public void setTotalNumOfGuest(int totalNumOfGuest) {
        this.totalNumOfGuest = totalNumOfGuest;
    }

    public String getBookingConfirmationCode() {
        return bookingConfirmationCode;
    }

    public void setBookingConfirmationCode(String bookingConfirmationCode) {
        this.bookingConfirmationCode = bookingConfirmationCode;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookedRoomResponse that = (BookedRoomResponse) o;
        return numOfAdults == that.numOfAdults && numOfChildren == that.numOfChildren && totalNumOfGuest == that.totalNumOfGuest && Objects.equals(bookingId, that.bookingId) && Objects.equals(checkInDate, that.checkInDate) && Objects.equals(checkOutDate, that.checkOutDate) && Objects.equals(guestFullName, that.guestFullName) && Objects.equals(guestEmail, that.guestEmail) && Objects.equals(bookingConfirmationCode, that.bookingConfirmationCode) && Objects.equals(room, that.room);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, checkInDate, checkOutDate, guestFullName, guestEmail, numOfAdults, numOfChildren, totalNumOfGuest, bookingConfirmationCode, room);
    }

    @Override
    public String toString() {
        return "BookedRoomResponse{" +
                "bookingId=" + bookingId +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", guestFullName='" + guestFullName + '\'' +
                ", guestEmail='" + guestEmail + '\'' +
                ", numOfAdults=" + numOfAdults +
                ", numOfChildren=" + numOfChildren +
                ", totalNumOfGuest=" + totalNumOfGuest +
                ", bookingConfirmationCode='" + bookingConfirmationCode + '\'' +
                ", room=" + room +
                '}';
    }
}
