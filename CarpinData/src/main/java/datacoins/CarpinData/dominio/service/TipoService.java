package datacoins.CarpinData.dominio.service;

import datacoins.CarpinData.dominio.dto.ModTipoDto;
import datacoins.CarpinData.dominio.dto.TipoDto;
import datacoins.CarpinData.dominio.repository.TipoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoService {

    private final TipoRepository tipoRepository;

    public TipoService(TipoRepository tipoRepository){
        this.tipoRepository = tipoRepository;
    }

    //Obtiene todos los tipos registrados.

    public List<TipoDto> obtenerTodo(){
        return this.tipoRepository.obtenerTodo();
    }

    //Obtiene un tipo por su ID.
    public TipoDto obtenerTipoPorId(Long id){
        return this.tipoRepository.obtenerTipoPorId(id);
    }

    //Guarda un nuevo tipo.
    public TipoDto guardarTipo(TipoDto tipoDto){
        return this.tipoRepository.guardarTipo(tipoDto);
    }

    //Modifica un tipo existente.
    public TipoDto modificarTipo(Long id, ModTipoDto modTipoDto){
        return this.tipoRepository.modificarTipo(id, modTipoDto);
    }

    //Elimina un tipo por su ID.
    public void eliminarTipo(Long id){
        this.tipoRepository.eliminarTipo(id);
    }
}