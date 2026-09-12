package com.jorgegalvan.testkairos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jorgegalvan.testkairos.models.estrucutra.Network;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class TvShow {
    private Long id;
    private String name;
    private Network network;
    private Network webChannel;
    private String summary;
    private List<String> genres;

}
