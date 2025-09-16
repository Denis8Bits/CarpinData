package datacoins.CarpinData.dominio.repository;

import datacoins.CarpinData.dominio.dto.MuebleDto;
import datacoins.CarpinData.dominio.dto.ModMuebleDto;

import java.util.List;

public interface MuebleRepository {
    // Firmas del mantenimiento de DTO
    List<MuebleDto> obtenerTodo();
    MuebleDto obtenerMueblePorCodigo(Long codigo);
    MuebleDto guardarMueble(MuebleDto muebleDto);
    MuebleDto modificarMueble(Long codigo, ModMuebleDto muebleDto);
    void eliminarMueble(Long codigo);
}
