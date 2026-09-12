package com.jorgegalvan.testkairos.services;

import com.jorgegalvan.testkairos.clients.TvMazeClient;
import com.jorgegalvan.testkairos.dto.ShowDto;
import com.jorgegalvan.testkairos.mappers.ShowMapper;
import com.jorgegalvan.testkairos.models.TvMazeResultado;
import com.jorgegalvan.testkairos.models.TvMazeShow;
import com.jorgegalvan.testkairos.repository.TvShowRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ShowServiceImp implements ShowService {
    private final TvMazeClient tvMazeClient;
    private final RestTemplate restTemplate;
    private final ShowMapper showMapper;
    private final TvShowRepository showRepository;

    @Override
    public List<ShowDto> buscarShows(String searchQuery) {
        List<TvMazeResultado> searchResults = tvMazeClient.searchShows(searchQuery);

        if (searchResults == null || searchResults.isEmpty()) {
            return List.of();
        }

        return showMapper.toDtoList(searchResults);
    }

    @Override
    public TvMazeShow showById(Long showId) {
        Optional<TvMazeShow> optionalShow = showRepository.findById(showId);
        if (optionalShow.isPresent()) {
            return optionalShow.get();
        }

        try {
            TvMazeShow apiShow = tvMazeClient.buscarPorId(showId);

            if (apiShow != null) {
                return showRepository.save(apiShow);
            }
        } catch (feign.FeignException.NotFound e) {
            return null;
        }
        return null;
    }
}
