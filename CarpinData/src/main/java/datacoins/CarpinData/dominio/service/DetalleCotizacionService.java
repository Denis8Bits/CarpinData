package datacoins.CarpinData.dominio.service;

import datacoins.CarpinData.dominio.dto.ModDetalleCotizacionDto;
import datacoins.CarpinData.dominio.dto.DetalleCotizacionDto;
import datacoins.CarpinData.dominio.repository.DetalleCotizacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleCotizacionService {

    private final DetalleCotizacionRepository detalleCotizacionRepository;

    public DetalleCotizacionService(DetalleCotizacionRepository detalleCotizacionRepository){
        this.detalleCotizacionRepository = detalleCotizacionRepository;
    }

    public List<DetalleCotizacionDto> obtenerTodo(){
        return this.detalleCotizacionRepository.obtenerTodo();
    }

    public DetalleCotizacionDto obtenerDetalleCotizacionPorCodigo(Long codigo){
        return this.detalleCotizacionRepository.obtenerDetalleCotizacionPorCodigo(codigo);
    }

    public DetalleCotizacionDto guardarDetalleCotizacion(DetalleCotizacionDto detalleCotizacionDto){
        return this.detalleCotizacionRepository.guardarDetalleCotizacion(detalleCotizacionDto);
    }

    public DetalleCotizacionDto modificarDetalleCotizacion(Long codigo, ModDetalleCotizacionDto modDetalleCotizacionDto){
        return this.detalleCotizacionRepository.modificarDetalleCotizacion(codigo, modDetalleCotizacionDto);
    }

    public void eliminarDetalleCotizacion(Long codigo){
        this.detalleCotizacionRepository.eliminarDetalleCotizacion(codigo);
    }
}