package com.jorgegalvan.testkairos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ComentarioDto {
    private String comment;
    private Integer rating;
}
