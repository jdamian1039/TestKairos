package com.jorgegalvan.testkairos.services;

import com.jorgegalvan.testkairos.clients.TvMazeClient;
import com.jorgegalvan.testkairos.dto.ShowDto;
import com.jorgegalvan.testkairos.mappers.ShowMapper;
import com.jorgegalvan.testkairos.models.TvMazeResultado;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class ShowServiceImp implements ShowService {
    private final TvMazeClient tvMazeClient;
    private final RestTemplate restTemplate;
    private final ShowMapper showMapper;

    @Override
    public List<ShowDto> searchShows(String searchQuery) {
        List<TvMazeResultado> searchResults = tvMazeClient.searchShows(searchQuery);

        if (searchResults == null || searchResults.isEmpty()) {
            return List.of();
        }

        return showMapper.toDtoList(searchResults);
    }
}
