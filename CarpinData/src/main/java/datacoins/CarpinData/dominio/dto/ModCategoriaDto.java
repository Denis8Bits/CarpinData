package datacoins.CarpinData.dominio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ModCategoriaDto(
        Long codigo,

        @NotBlank(message = "El nombre del mueble es obligatorio")
        @Size(max = 150, message = "El nombre no debe exceder los 150 caracteres")
        String nombre,

        @NotBlank(message = "la descripcion es obligatorio")
        @Size(max = 150, message = "La descripcion no debe exceder los 60 caracteres")
        String descripcion,

        @NotBlank(message = "El estado del mueble es obligatorio")
        @Size(max = 150, message = "El estado debe activo o incativo")
        String estado) {
}
