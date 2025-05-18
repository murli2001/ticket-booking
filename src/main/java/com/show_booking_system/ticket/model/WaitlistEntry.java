package com.show_booking_system.ticket.model;

public class WaitlistEntry {
    private String userName;
    private int persons;

    // Constructor, Getters & Setters


    public WaitlistEntry(String userName, int persons) {
        this.userName = userName;
        this.persons = persons;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getPersons() {
        return persons;
    }

    public void setPersons(int persons) {
        this.persons = persons;
    }
}