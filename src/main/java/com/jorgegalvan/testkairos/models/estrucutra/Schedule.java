package com.jorgegalvan.testkairos.models.estrucutra;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class Schedule {
    private String time;
    private List<String> days;
}
