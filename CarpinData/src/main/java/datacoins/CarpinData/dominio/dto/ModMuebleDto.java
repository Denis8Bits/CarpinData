package datacoins.CarpinData.dominio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ModMuebleDto(

        Long codigo,

        @NotBlank(message = "El color del mueble es obligatorio")
        @Size(max = 150, message = "El color no debe exceder los 150 caracteres")
        String color,

        @NotBlank(message = "El tamaño del mueble es obligatorio")
        @Size(max = 150, message = "El tamaño no debe exceder los 150 caracteres")
        String tamaño,

        @NotBlank(message = "El estilo del mueble es obligatorio")
        @Size(max = 150, message = "El estilo no debe exceder los 150 caracteres")
        String estilo
) {
}
