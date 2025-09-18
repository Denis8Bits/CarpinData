package datacoins.CarpinData.dominio.dto;

import java.time.LocalDate;

public record ClienteDto (
        Long codigo,
        String nombre,
        String apellido,
        Integer telefono,
        String genero,
        LocalDate fechaNacimiento
) {
}
