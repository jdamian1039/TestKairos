package com.jorgegalvan.testkairos.services;

import com.jorgegalvan.testkairos.dto.ShowDto;

import java.util.List;

public interface ShowService {
    List<ShowDto> searchShows(String searchQuery);
}
