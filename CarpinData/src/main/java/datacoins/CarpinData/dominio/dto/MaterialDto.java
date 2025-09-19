package datacoins.CarpinData.dominio.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record MaterialDto(
        Long codigo,
        String nombre,
        String descripcion,
        BigDecimal costo,
        Integer stock,
        LocalDate fechaIngreso,
        String estado
)  {
}
