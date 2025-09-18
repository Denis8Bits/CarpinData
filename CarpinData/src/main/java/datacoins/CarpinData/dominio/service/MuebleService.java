package datacoins.CarpinData.dominio.service;

import datacoins.CarpinData.dominio.dto.ModMuebleDto;
import datacoins.CarpinData.dominio.dto.MuebleDto;
import datacoins.CarpinData.dominio.repository.MuebleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MuebleService {

    private final MuebleRepository muebleRepository;

    public MuebleService(MuebleRepository muebleRepository){
        this.muebleRepository = muebleRepository;
    }

    public List<MuebleDto> obtenerTodo(){
        return this.muebleRepository.obtenerTodo();
    }

    public MuebleDto obtenerMueblePorCodigo(Long codigo){
        return this.muebleRepository.obtenerMueblePorCodigo(codigo);
    }

    public MuebleDto guardarMueble(MuebleDto muebleDto){
        return this.muebleRepository.guardarMueble(muebleDto);
    }

    public MuebleDto modificarMueble(Long codigo, ModMuebleDto modMuebleDto){
        return this.muebleRepository.modificarMueble(codigo, modMuebleDto);
    }

    public void eliminarMueble(Long codigo){
        this.muebleRepository.eliminarMueble(codigo);
    }
}
