package datacoins.CarpinData.dominio.dto;

import java.time.LocalDate;

public record ReservaDto(Long idReservas,
                         LocalDate fechaReserva,
                         String estado,
                         Long idUsuario,
                         Long idMueble) {
}