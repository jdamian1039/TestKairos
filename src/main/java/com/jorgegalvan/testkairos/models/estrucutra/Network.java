package com.jorgegalvan.testkairos.models.estrucutra;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class Network {
    private Long id;
    private String name;
    private Map<String, String> country;
    private String officialSite;
}
