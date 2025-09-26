package datacoins.CarpinData.dominio.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ModDetalleCotizacionDto(
        Long id,

        @NotNull(message = "El ID del mueble es obligatorio")
        @Positive(message = "El ID del mueble debe ser un número positivo")
        Long idMueble,

        @NotNull(message = "El ID de la cotización es obligatorio")
        @Positive(message = "El ID de la cotización debe ser un número positivo")
        Long idCotizacion
) {
}