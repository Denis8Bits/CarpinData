package datacoins.CarpinData.dominio.service;

import datacoins.CarpinData.dominio.dto.ModCotizacionDto;
import datacoins.CarpinData.dominio.dto.CotizacionDto;
import datacoins.CarpinData.dominio.repository.CotizacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CotizacionService {

    private final CotizacionRepository cotizacionRepository;

    public CotizacionService(CotizacionRepository cotizacionRepository){
        this.cotizacionRepository = cotizacionRepository;
    }

    public List<CotizacionDto> obtenerTodo(){
        return this.cotizacionRepository.obtenerTodo();
    }

    public CotizacionDto obtenerCotizacionPorCodigo(Long codigo){
        return this.cotizacionRepository.obtenerCotizacionPorCodigo(codigo);
    }

    public CotizacionDto guardarCotizacion(CotizacionDto cotizacionDto){
        return this.cotizacionRepository.guardarCotizacion(cotizacionDto);
    }

    public CotizacionDto modificarCotizacion(Long codigo, ModCotizacionDto modCotizacionDto){
        return this.cotizacionRepository.modificarCotizacion(codigo, modCotizacionDto);
    }

    public void eliminarCotizacion(Long codigo){
        this.cotizacionRepository.eliminarCotizacion(codigo);
    }
}