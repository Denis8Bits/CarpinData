package datacoins.CarpinData.dominio.dto;

import datacoins.CarpinData.dominio.entity.TipoEntity.EstadoTipo;

public record TipoDto(
        Long id,
        String nombre,
        String descripcion,
        EstadoTipo estado
) {
}