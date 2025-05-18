package com.show_booking_system.ticket.controller;

import com.show_booking_system.ticket.model.Genre;
import org.springframework.web.bind.annotation.*;
import com.show_booking_system.ticket.service.ShowService;

import java.util.List;
import java.util.Map;

@RestController
public class ShowController {
    private final ShowService showService = new ShowService();

    @PostMapping("registerShow")
    public String registerShow(@RequestParam String name, @RequestParam Genre genre) {
        System.out.println("Registering show");
        return showService.registerShow(name, genre);
    }

    @PostMapping("/onboardShowSlots")
    public String onboardSlots(@RequestParam String showName, @RequestBody Map<String, Integer> slots) {
        return showService.onboardShowSlots(showName, slots);
    }

    @GetMapping("/showAvailByGenre")
    public List<String> getShows(@RequestParam Genre genre) {
        System.out.println("Shows available");
        return showService.getAvailableShowsByGenre(genre);
    }
}