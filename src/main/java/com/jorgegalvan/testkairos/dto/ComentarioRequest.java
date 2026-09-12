package com.jorgegalvan.testkairos.dto;

import jakarta.validation.constraints.*;

public record ComentarioRequest(
        @NotNull(message = "El show_id es obligatorio")
        Long showId,
        @NotBlank(message = "El comentario no puede estar vacío")
        String comment,
        @NotNull(message = "El rating es obligatorio")
        @Min(value = 0, message = "El rating mínimo es 0")
        @Max(value = 5, message = "El rating máximo es 5")
        Integer rating
) {


}
