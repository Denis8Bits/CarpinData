package datacoins.CarpinData.persistence.entity;

import datacoins.CarpinData.dominio.dto.ModMaterialDto;
import datacoins.CarpinData.dominio.dto.MaterialDto;
import datacoins.CarpinData.dominio.exception.MaterialNoExisteException;
import datacoins.CarpinData.dominio.exception.MaterialYaExisteException;
import datacoins.CarpinData.dominio.repository.MaterialRepository;
import datacoins.CarpinData.persistence.crud.CrudMaterialEntity;
import datacoins.CarpinData.web.mapper.MaterialMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MaterialEntityRepository implements MaterialRepository {

    private final CrudMaterialEntity crudMaterial;
    private final MaterialMapper materialMapper;

    public MaterialEntityRepository(CrudMaterialEntity crudMaterial, MaterialMapper materialMapper) {
        this.crudMaterial = crudMaterial;
        this.materialMapper = materialMapper;
    }

    @Override
    public List<MaterialDto> obtenerTodo() {
        return this.materialMapper.toDto(this.crudMaterial.findAll());
    }

    @Override
    public MaterialDto obtenerMaterialPorCodido(Long codigo) {
        MaterialEntity materialEntity = this.crudMaterial.findById(codigo).orElse(null);
        if (materialEntity == null) throw new MaterialNoExisteException(codigo);
        return this.materialMapper.toDto(materialEntity);
    }

    @Override
    public MaterialDto guardarMaterial(MaterialDto materialDto) {
        if (this.crudMaterial.findFirstByNombre(materialDto.nombre()) != null) {
            throw new MaterialYaExisteException(materialDto.nombre());
        }
        MaterialEntity material = this.materialMapper.toEntity(materialDto);
        material.setEstado("D");
        this.crudMaterial.save(material);
        return this.materialMapper.toDto(material);
    }

    @Override
    public MaterialDto modificarMaterial(Long codigo, ModMaterialDto modMaterialDto) {
        MaterialEntity material = this.crudMaterial.findById(codigo).orElse(null);
        if (material == null) throw new MaterialNoExisteException(codigo);

        this.materialMapper.modificarEntityFromDto(modMaterialDto, material);
        return this.materialMapper.toDto(this.crudMaterial.save(material));
    }

    @Override
    public void eliminarMaterial(Long codigo) {
        MaterialEntity materialEntity = this.crudMaterial.findById(codigo).orElse(null);
        if (materialEntity == null) {
            throw new MaterialNoExisteException(codigo);
        } else {
            this.crudMaterial.deleteById(codigo);
        }
    }
}