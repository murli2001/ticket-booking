package com.show_booking_system.ticket.model;

import java.util.HashMap;
import java.util.Map;

public class Show {
    private String name;
    private Genre genre;
    private Map<String, ShowSlot> slots = new HashMap<>();

    public Show(String name, Genre genre) {
        this.name = name;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Map<String, ShowSlot> getSlots() {
        return slots;
    }

    public void setSlots(Map<String, ShowSlot> slots) {
        this.slots = slots;
    }
}
