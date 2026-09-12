package com.jorgegalvan.testkairos.services;

import com.jorgegalvan.testkairos.dto.ShowDto;
import com.jorgegalvan.testkairos.models.TvMazeShow;

import java.util.List;

public interface ShowService {
    List<ShowDto> buscarShows(String searchQuery);
    TvMazeShow showById(Long showId);
}
