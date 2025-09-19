package datacoins.CarpinData.dominio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ModTipoDto(

        Long id,

        @NotBlank(message = "El nombre del tipo es obligatorio")
        @Size(max = 150, message = "El nombre no debe exceder los 150 caracteres")
        String nombre,

        @Size(max = 300, message = "La descripción no debe exceder los 300 caracteres")
        String descripcion,

        @NotNull(message = "El estado del tipo es obligatorio")
        String estado
) {
}