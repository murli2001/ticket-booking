package com.show_booking_system.ticket.service;

import com.show_booking_system.ticket.model.Genre;
import com.show_booking_system.ticket.model.Show;
import com.show_booking_system.ticket.model.ShowSlot;
import com.show_booking_system.ticket.repository.InMemoryRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ShowService {
    public String registerShow(String name, Genre genre) {
        InMemoryRepository.shows.put(name, new Show(name, genre));
        return name + " show is registered !!";
    }

    public String onboardShowSlots(String showName, Map<String, Integer> slots) {
        Show show = InMemoryRepository.shows.get(showName);
        if (show == null) return "Show not found";

        for (String time : slots.keySet()) {
            // Check format first
            if (!time.matches("\\d{2}:00-\\d{2}:00"))
                return "Invalid time format";

            // Parse start and end hour
            String[] parts = time.split("-");
            int startHour = Integer.parseInt(parts[0].substring(0, 2));
            int endHour = Integer.parseInt(parts[1].substring(0, 2));

            // Check that duration is exactly 1 hour
            if (endHour - startHour != 1) {
                return "Sorry, show timings are of 1 hour only";
            }

            // Add slot
            show.getSlots().put(time, new ShowSlot(time, slots.get(time)));
        }
        return "Done!";
    }

    public List<String> getAvailableShowsByGenre(Genre genre) {
        return InMemoryRepository.shows.values().stream()
                .filter(show -> show.getGenre() == genre)
                .flatMap(show -> show.getSlots().entrySet().stream()
                        .filter(e -> e.getValue().getCapacity() > e.getValue().getBooked())
                        .map(e -> show.getName() + ": (" + e.getKey() + ") " + (e.getValue().getCapacity() - e.getValue().getBooked())))
                .sorted() // Ranking by start time
                .collect(Collectors.toList());
    }
}