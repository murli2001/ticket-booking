package com.show_booking_system.ticket.controller;

import com.show_booking_system.ticket.dto.BookingRequest;
import org.springframework.web.bind.annotation.*;
import com.show_booking_system.ticket.service.BookingService;

@RestController
public class BookingController {
    private final BookingService bookingService = new BookingService();

    @PostMapping("/bookTicket")
    public String book(@RequestBody BookingRequest request) {
        return bookingService.bookTicket(
                request.getUser(),
                request.getShow(),
                request.getTime(),
                request.getPersons()
        );
    }

    @DeleteMapping("/cancelBooking")
    public String cancel(@RequestParam String id) {
        return bookingService.cancelBooking(id);
    }
}
