package com.jorgegalvan.testkairos.services;

import com.jorgegalvan.testkairos.dto.ComentarioRequest;
import com.jorgegalvan.testkairos.dto.ComentarioResponse;
import com.jorgegalvan.testkairos.dto.ShowDto;
import com.jorgegalvan.testkairos.models.TvMazeShow;

import java.util.List;

public interface ShowService {
    List<ShowDto> buscarShows(String searchQuery);
    TvMazeShow showById(Long showId);
    ComentarioResponse publicarComentario(ComentarioRequest commentRequest);
}
