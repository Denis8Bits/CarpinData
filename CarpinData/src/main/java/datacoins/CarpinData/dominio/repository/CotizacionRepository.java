package datacoins.CarpinData.dominio.repository;

import datacoins.CarpinData.dominio.dto.CotizacionDto;
import datacoins.CarpinData.dominio.dto.ModCotizacionDto;

import java.util.List;

public interface CotizacionRepository {
    List<CotizacionDto> obtenerTodo();
    CotizacionDto obtenerCotizacionPorCodigo(Long codigo);
    CotizacionDto guardarCotizacion(CotizacionDto cotizacionDto);
    CotizacionDto modificarCotizacion(Long codigo, ModCotizacionDto cotizacionDto);
    void eliminarCotizacion(Long codigo);
}