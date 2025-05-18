package com.show_booking_system.ticket.repository;

import com.show_booking_system.ticket.model.Booking;
import com.show_booking_system.ticket.model.Show;
import com.show_booking_system.ticket.model.User;

import java.util.HashMap;
import java.util.Map;

public class InMemoryRepository {
    public static final Map<String, Show> shows = new HashMap<>();
    public static final Map<String, User> users = new HashMap<>();
    public static final Map<String, Booking> bookings = new HashMap<>();
}