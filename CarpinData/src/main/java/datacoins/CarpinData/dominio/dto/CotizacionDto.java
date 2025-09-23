package datacoins.CarpinData.dominio.dto;

import java.math.BigDecimal;

public record CotizacionDto(
        Long id,
        Integer cantidad,
        BigDecimal total,
        String descripcion
) {
}