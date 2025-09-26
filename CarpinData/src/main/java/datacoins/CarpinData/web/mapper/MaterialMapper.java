package datacoins.CarpinData.web.mapper;

import datacoins.CarpinData.dominio.dto.ModMaterialDto;
import datacoins.CarpinData.dominio.dto.MaterialDto;
import datacoins.CarpinData.persistence.entity.MaterialEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MaterialMapper {

    //ENTITY -> DTO
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "descripcion", target = "descripcion")
    @Mapping(source = "costo", target = "costo")
    @Mapping(source = "stock", target = "stock")
    @Mapping(source = "fechaIngreso", target = "fechaIngreso")
    @Mapping(source = "estado", target = "estado")
    public MaterialDto toDto(MaterialEntity entity);

    public List<MaterialDto> toDto(Iterable<MaterialEntity> entities);

    //DTO -> ENTITY
    @InheritInverseConfiguration
    MaterialEntity toEntity(MaterialDto dto);

    //Modificar ENTITY con un ModMaterialDto
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "descripcion", target = "descripcion")
    @Mapping(source = "costo", target = "costo")
    @Mapping(source = "stock", target = "stock")
    @Mapping(source = "fechaIngreso", target = "fechaIngreso")
    @Mapping(source = "estado", target = "estado")
    @Mapping(target = "id", ignore = true)
    void modificarEntityFromDto(ModMaterialDto modMaterialDto, @MappingTarget MaterialEntity materialEntity);
}
