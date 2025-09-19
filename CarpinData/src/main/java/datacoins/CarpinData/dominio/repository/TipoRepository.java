package datacoins.CarpinData.dominio.repository;

import datacoins.CarpinData.dominio.dto.TipoDto;
import datacoins.CarpinData.dominio.dto.ModTipoDto;

import java.util.List;

public interface TipoRepository {
    // Firmas del mantenimiento de DTO
    List<TipoDto> obtenerTodo();
    TipoDto obtenerTipoPorId(Long id);
    TipoDto guardarTipo(TipoDto tipoDto);
    TipoDto modificarTipo(Long id, ModTipoDto tipoDto);
    void eliminarTipo(Long id);
}