package datacoins.CarpinData.dominio.service;

import datacoins.CarpinData.dominio.dto.ReservaDto;
import datacoins.CarpinData.dominio.dto.ModReservaDto;
import datacoins.CarpinData.dominio.repository.ReservaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {
    private final ReservaRepository reservaRepository;

    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public List<ReservaDto> obtenerTodo(){
        return this.reservaRepository.obtenerTodo();
    }

    public ReservaDto obtenerReservaPorId(Long id){
        return this.reservaRepository.obtenerReservaPorId(id);
    }

    public ReservaDto guardarReserva(ReservaDto reservaDto){
        return this.reservaRepository.guardarReserva(reservaDto);
    }

    public ReservaDto modificarReserva(Long id, ModReservaDto modReservaDto){
        return this.reservaRepository.modificarReserva(id, modReservaDto);
    }

    public void eliminarReserva(Long id){
        this.reservaRepository.eliminarReserva(id);
    }
}