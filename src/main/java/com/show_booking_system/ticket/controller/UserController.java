package com.show_booking_system.ticket.controller;

import com.show_booking_system.ticket.model.Booking;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.show_booking_system.ticket.service.UserService;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService = new UserService();

    @GetMapping("/bookings")
    public List<Booking> getBookings(@RequestParam String userName) {
        return userService.getUserBookings(userName);
    }
}
