package datacoins.CarpinData.dominio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public record ModReservaDto(
        Long idReservas,

        @NotNull(message = "La fecha de reserva es obligatoria")
        LocalDate fechaReserva,

        @NotBlank(message = "El estado de la reserva es obligatorio")
        @Size(max = 50, message = "El estado no debe exceder los 50 caracteres")
        String estado,

        @NotNull(message = "El ID del usuario es obligatorio")
        Long idUsuario,

        @NotNull(message = "El ID del mueble es obligatorio")
        Long idMueble) {
}