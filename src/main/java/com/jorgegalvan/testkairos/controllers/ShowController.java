package com.jorgegalvan.testkairos.controllers;

import com.jorgegalvan.testkairos.dto.ShowDto;
import com.jorgegalvan.testkairos.services.ShowService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/shows")
public class ShowController {

    private final ShowService showService;

    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    @GetMapping("/search")
    public ResponseEntity<List<ShowDto>> searchShows(@RequestParam("search_query") String searchQuery) {
        List<ShowDto> shows = showService.searchShows(searchQuery);
        return ResponseEntity.ok(shows);
    }
}
