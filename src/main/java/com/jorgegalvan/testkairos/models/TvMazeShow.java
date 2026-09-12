package com.jorgegalvan.testkairos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jorgegalvan.testkairos.models.estrucutra.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class TvMazeShow {

    private Long id;
    private String url;
    private String name;
    private String type;
    private String language;
    private List<String> genres;
    private String status;
    private Integer runtime;
    private Integer averageRuntime;
    private String premiered;
    private String ended;
    private String officialSite;
    private Schedule schedule;
    private Rating rating;
    private Integer weight;
    private Network network;
    private Network webChannel;
    private Map<String, String> dvdCountry;
    private Externals externals;
    private Image image;
    private String summary;
    private Long updated;
    private Links _links;
}
