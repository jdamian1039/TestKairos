package com.jorgegalvan.testkairos.services;

import com.jorgegalvan.testkairos.clients.TvMazeClient;
import com.jorgegalvan.testkairos.dto.*;
import com.jorgegalvan.testkairos.mappers.ComentarioMapper;
import com.jorgegalvan.testkairos.mappers.ShowMapper;
import com.jorgegalvan.testkairos.models.Comentario;
import com.jorgegalvan.testkairos.models.TvMazeResultado;
import com.jorgegalvan.testkairos.models.TvMazeShow;
import com.jorgegalvan.testkairos.repository.ComentarioRepository;
import com.jorgegalvan.testkairos.repository.TvShowRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ShowServiceImp implements ShowService {
    private final TvMazeClient tvMazeClient;
    private final RestTemplate restTemplate;
    private final ShowMapper showMapper;
    private final TvShowRepository showRepository;
    private final ComentarioRepository comentarioRepository;
    private final ComentarioMapper comentarioMapper;

    @Override
    public List<ShowDto> buscarShows(String searchQuery) {
        List<TvMazeResultado> respuesta = tvMazeClient.searchShows(searchQuery);

        if (respuesta == null || respuesta.isEmpty()) {
            return List.of();
        }


        List<Long> showIds = respuesta.stream()
                .filter(res -> res.getShow() != null)
                .map(res -> res.getShow().getId())
                .toList();

        List<Comentario> comments = comentarioRepository.findByShowIdIn(showIds);

        Map<Long, List<Comentario>> commentsByShowId = comments.stream()
                .collect(Collectors.groupingBy(Comentario::getShowId));

        return showMapper.toDtoList(respuesta, commentsByShowId);
    }

    @Override
    public DetalleShowDto showById(Long showId) {
        TvMazeShow show = null;

        Optional<TvMazeShow> optionalShow = showRepository.findById(showId);
        if (optionalShow.isPresent()) {
            show = optionalShow.get();
        }else{
            show = tvMazeClient.buscarPorId(showId);
            if (show != null)
                show = showRepository.save(show);
        }
        if (show == null)
            return null;

        List<Comentario> comments = comentarioRepository.findByShowId(showId);

        List<ComentarioDto> commentDtos = comments.stream()
                .map(c -> new ComentarioDto(c.getComment(), c.getRating()))
                .toList();

        // 4. Retornar el objeto con la información del show + arreglo de comentarios
        return new DetalleShowDto(show, commentDtos);
    }

    @Override
    public ComentarioResponse publicarComentario(ComentarioRequest commentRequest) {
        Comentario comment = comentarioMapper.requestAEntidad(commentRequest);

        comentarioRepository.save(comment);

        return new ComentarioResponse("SUCCESS",
                "Comentario registrado correctamente para el show " + commentRequest.showId());
    }
}
