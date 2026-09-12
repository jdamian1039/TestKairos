package com.jorgegalvan.testkairos.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "comments")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Comentario {
    @Id
    private String id;
    private Long showId;
    private String comment;
    private Integer rating;
    private LocalDateTime createdAt;

    public Comentario(Long showId, String comment, Integer rating, LocalDateTime createdAt) {
        this.showId = showId;
        this.comment = comment;
        this.rating = rating;
        this.createdAt = createdAt;
    }

}
