package com.jorgegalvan.testkairos.models.estrucutra;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class Image {
    private String medium;
    private String original;
}
