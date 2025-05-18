package com.show_booking_system.ticket.model;

import java.util.UUID;

public class Booking {
    private String bookingId = UUID.randomUUID().toString();
    private String userName;
    private String showName;
    private String timeSlot;
    private int persons;

    // Constructor, Getters & Setters


    public Booking(String userName, String showName, String timeSlot, int persons) {
        this.bookingId = bookingId;
        this.userName = userName;
        this.showName = showName;
        this.timeSlot = timeSlot;
        this.persons = persons;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public int getPersons() {
        return persons;
    }

    public void setPersons(int persons) {
        this.persons = persons;
    }
}