package com.show_booking_system.ticket.service;

import com.show_booking_system.ticket.model.Booking;
import com.show_booking_system.ticket.model.User;
import com.show_booking_system.ticket.repository.InMemoryRepository;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    public User getOrCreateUser(String name) {
        return InMemoryRepository.users.computeIfAbsent(name, User::new);
    }

    public List<Booking> getUserBookings(String userName) {
        User user = InMemoryRepository.users.get(userName);
        return user != null ? user.getBookings() : new ArrayList<>();
    }
}