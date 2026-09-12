package com.jorgegalvan.testkairos.dto;

import com.jorgegalvan.testkairos.models.TvMazeShow;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DetalleShowDto {
    private TvMazeShow show;
    private List<ComentarioDto> comments;
}
