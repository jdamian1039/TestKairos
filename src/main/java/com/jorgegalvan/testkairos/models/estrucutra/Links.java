package com.jorgegalvan.testkairos.models.estrucutra;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class Links {
    private Map<String, String> self;
    private Map<String, String> previousepisode;
}
