package com.jorgegalvan.testkairos.mappers;

import com.jorgegalvan.testkairos.dto.ComentarioDto;
import com.jorgegalvan.testkairos.dto.ShowDto;
import com.jorgegalvan.testkairos.models.Comentario;
import com.jorgegalvan.testkairos.models.TvMazeResultado;
import com.jorgegalvan.testkairos.models.TvShow;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class ShowMapper {

    public ShowDto toDto(TvMazeResultado searchResult, List<Comentario> comentarios) {
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

        List<ComentarioDto> comentariosDto = (comentarios == null) ? List.of() :
                comentarios.stream()
                        .map(c -> new ComentarioDto(c.getComment(), c.getRating()))
                        .toList();

        return new ShowDto(
                show.getId(),
                show.getName(),
                channelName,
                show.getSummary(),
                show.getGenres(),
                comentariosDto
        );
    }

    public List<ShowDto> toDtoList(List<TvMazeResultado> searchResults, Map<Long, List<Comentario>> comentariosPorIdShow) {
        if (searchResults == null) {
            return List.of();
        }

        return searchResults.stream()
                .map(item -> {
                    Long showId = item.getShow() != null ? item.getShow().getId() : null;
                    List<Comentario> comments = comentariosPorIdShow.getOrDefault(showId, List.of());
                    return toDto(item, comments);
                })
                .toList();
    }
}
