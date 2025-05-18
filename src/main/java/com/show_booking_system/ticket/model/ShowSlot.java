package com.show_booking_system.ticket.model;

import java.util.ArrayList;
import java.util.List;

public class ShowSlot {
    private String time; // e.g., 09:00-10:00
    private int capacity;
    private int booked;
    private List<WaitlistEntry> waitlist = new ArrayList<>();

    // Constructor, Getters & Setters


    public ShowSlot(String time, int capacity) {
        this.time = time;
        this.capacity = capacity;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getBooked() {
        return booked;
    }

    public void setBooked(int booked) {
        this.booked = booked;
    }

    public List<WaitlistEntry> getWaitlist() {
        return waitlist;
    }

    public void setWaitlist(List<WaitlistEntry> waitlist) {
        this.waitlist = waitlist;
    }
}