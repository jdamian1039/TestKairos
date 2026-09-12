package com.jorgegalvan.testkairos.mappers;

import com.jorgegalvan.testkairos.dto.ShowDto;
import com.jorgegalvan.testkairos.models.TvMazeResultado;
import com.jorgegalvan.testkairos.models.TvShow;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShowMapper {

    public ShowDto toDto(TvMazeResultado searchResult) {
        if (searchResult == null || searchResult.getShow() == null) {
            return null;
        }

        TvShow show = searchResult.getShow();

        // Determinar si el canal proviene de Network o WebChannel
        String channelName = null;
        if (show.getNetwork() != null) {
            channelName = show.getNetwork().getName();
        } else if (show.getWebChannel() != null) {
            channelName = show.getWebChannel().getName();
        }

        return new ShowDto(
                show.getId(),
                show.getName(),
                channelName,
                show.getSummary(),
                show.getGenres()
        );
    }

    public List<ShowDto> toDtoList(List<TvMazeResultado> searchResults) {
        if (searchResults == null) {
            return List.of();
        }

        return searchResults.stream()
                .map(this::toDto)
                .toList();
    }
}
