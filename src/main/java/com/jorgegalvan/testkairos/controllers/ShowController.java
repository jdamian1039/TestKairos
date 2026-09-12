package com.jorgegalvan.testkairos.controllers;

import com.jorgegalvan.testkairos.dto.ShowDto;
import com.jorgegalvan.testkairos.models.TvMazeShow;
import com.jorgegalvan.testkairos.services.ShowService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        List<ShowDto> shows = showService.buscarShows(searchQuery);
        return ResponseEntity.ok(shows);
    }

    @GetMapping("/{showId}")
    public ResponseEntity<TvMazeShow> getShowById(@PathVariable Long showId) {
        TvMazeShow show = showService.showById(showId);
        if (show == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(show);
    }
}
