package datacoins.CarpinData.dominio.service;

import datacoins.CarpinData.dominio.dto.MaterialDto;
import datacoins.CarpinData.dominio.dto.ModMaterialDto;
import datacoins.CarpinData.dominio.repository.MaterialRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialService {
    private final MaterialRepository materialRepository;


    public MaterialService(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    public List<MaterialDto> obtenerTodo(){
        return this.materialRepository.obtenerTodo();
    }

    public MaterialDto obtenerMaterialPorCodigo(Long codigo){
        return this.materialRepository.obtenerMaterialPorCodido(codigo);
    }

    public MaterialDto guardarMaterial(MaterialDto materialDto){
        return this.materialRepository.guardarMaterial(materialDto);
    }

    public MaterialDto modificarMaterial(Long codigo, ModMaterialDto modMaterialDto){
        return this.materialRepository.modificarMaterial(codigo, modMaterialDto);
    }

    public void eliminarMaterial(Long codigo){
        this.materialRepository.eliminarMaterial(codigo);
    }
}
