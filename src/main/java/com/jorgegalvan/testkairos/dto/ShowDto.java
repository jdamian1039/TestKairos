package com.jorgegalvan.testkairos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ShowDto {
    private Long id;
    private String name;
    private String channel;
    private String summary;
    private List<String> genres;

}