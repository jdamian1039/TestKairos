package com.jorgegalvan.testkairos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class TvMazeResultado {
    private Double score;
    private TvShow show;

}
