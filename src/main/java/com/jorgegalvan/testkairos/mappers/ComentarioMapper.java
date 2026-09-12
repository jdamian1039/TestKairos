package com.jorgegalvan.testkairos.mappers;

import com.jorgegalvan.testkairos.dto.ComentarioRequest;
import com.jorgegalvan.testkairos.dto.ComentarioResponse;
import com.jorgegalvan.testkairos.models.Comentario;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ComentarioMapper {
    public Comentario requestAEntidad(ComentarioRequest request){
        if (request==null) return null;
        return new Comentario(
                request.showId(),
                request.comment(),
                request.rating(),
                LocalDateTime.now()
        );
    }
}
