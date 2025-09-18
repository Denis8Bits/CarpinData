package datacoins.CarpinData.dominio.repository;

import datacoins.CarpinData.dominio.dto.MaterialDto;
import datacoins.CarpinData.dominio.dto.ModMaterialDto;

import java.util.List;

public interface MaterialRepository {
    List<MaterialDto> obtenerTodo();
    MaterialDto obtenerMaterialPorCodido(Long codigo);
    MaterialDto guardarMaterial(MaterialDto materialDto);
    MaterialDto modificarMaterial(Long codigo, ModMaterialDto modMaterialDto);
    void eliminarMaterial(Long codigo);
}
