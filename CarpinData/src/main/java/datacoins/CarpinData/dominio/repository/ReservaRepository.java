package datacoins.CarpinData.dominio.repository;

import datacoins.CarpinData.dominio.dto.ReservaDto;
import datacoins.CarpinData.dominio.dto.ModReservaDto;

import java.util.List;

public interface ReservaRepository {
    List<ReservaDto> obtenerTodo();
    ReservaDto obtenerReservaPorId(Long id);
    ReservaDto guardarReserva(ReservaDto reservaDto);
    ReservaDto modificarReserva(Long id, ModReservaDto reservaDto);
    void eliminarReserva(Long id);
}