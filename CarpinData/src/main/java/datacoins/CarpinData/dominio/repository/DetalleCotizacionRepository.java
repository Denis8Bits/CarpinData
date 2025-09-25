package datacoins.CarpinData.dominio.repository;

import datacoins.CarpinData.dominio.dto.DetalleCotizacionDto;
import datacoins.CarpinData.dominio.dto.ModDetalleCotizacionDto;

import java.util.List;

public interface DetalleCotizacionRepository {
    // Firmas del mantenimiento de DTO
    List<DetalleCotizacionDto> obtenerTodo();
    DetalleCotizacionDto obtenerDetalleCotizacionPorCodigo(Long codigo);
    DetalleCotizacionDto guardarDetalleCotizacion(DetalleCotizacionDto detalleCotizacionDto);
    DetalleCotizacionDto modificarDetalleCotizacion(Long codigo, ModDetalleCotizacionDto detalleCotizacionDto);
    void eliminarDetalleCotizacion(Long codigo);
}