package com.show_booking_system.ticket.service;

import com.show_booking_system.ticket.model.*;
import com.show_booking_system.ticket.repository.InMemoryRepository;

import java.util.Iterator;

public class BookingService {
    public String bookTicket(String userName, String showName, String timeSlot, int persons) {
        User user = InMemoryRepository.users.computeIfAbsent(userName, User::new);
        Show show = InMemoryRepository.shows.get(showName);
        if (show == null) return "Show not found";
        ShowSlot slot = show.getSlots().get(timeSlot);
        if (slot == null) return "Slot not available";

        for (Booking b : user.getBookings()) {
            if (b.getTimeSlot().equals(timeSlot)) return "You already have a booking at this time.";
        }

        if (slot.getCapacity() - slot.getBooked() >= persons) {
            Booking booking = new Booking(userName, showName, timeSlot, persons);
            slot.setBooked(slot.getBooked() + persons);
            user.getBookings().add(booking);
            InMemoryRepository.bookings.put(booking.getBookingId(), booking);
            return "Booked. Booking id: " + booking.getBookingId();
        } else {
            slot.getWaitlist().add(new WaitlistEntry(userName, persons));
            return "Slot full. Added to waitlist.";
        }
    }

    public String cancelBooking(String bookingId) {
        Booking booking = InMemoryRepository.bookings.remove(bookingId);
        if (booking == null) return "Booking not found";

        Show show = InMemoryRepository.shows.get(booking.getShowName());
        if (show == null) return "Show not found";

        ShowSlot slot = show.getSlots().get(booking.getTimeSlot());
        if (slot == null) return "Slot not found";

        slot.setBooked(slot.getBooked() - booking.getPersons());

        User user = InMemoryRepository.users.get(booking.getUserName());
        if (user != null) user.getBookings().remove(booking);

        // Promote from waitlist
        Iterator<WaitlistEntry> it = slot.getWaitlist().iterator();
        while (it.hasNext()) {
            WaitlistEntry entry = it.next();
            if (slot.getCapacity() - slot.getBooked() >= entry.getPersons()) {
                bookTicket(entry.getUserName(), booking.getShowName(), booking.getTimeSlot(), entry.getPersons());
                it.remove();
                break;
            }
        }

        return "Booking Canceled";
    }
}