package com.show_booking_system.ticket.dto;

public class BookingRequest {
    private String user;
    private String show;
    private String time;
    private int persons;

    public BookingRequest() {}

    public BookingRequest(String user, String show, String time, int persons) {
        this.user = user;
        this.show = show;
        this.time = time;
        this.persons = persons;
    }

    public String getUser() { return user; }
    public void setUser(String user) { this.user = user; }

    public String getShow() { return show; }
    public void setShow(String show) { this.show = show; }

    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }

    public int getPersons() { return persons; }
    public void setPersons(int persons) { this.persons = persons; }
}
