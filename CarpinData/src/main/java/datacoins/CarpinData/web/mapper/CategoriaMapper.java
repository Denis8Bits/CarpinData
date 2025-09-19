package datacoins.CarpinData.web.mapper;

import datacoins.CarpinData.dominio.dto.CategoriaDto;
import datacoins.CarpinData.dominio.dto.ModCategoriaDto;
import datacoins.CarpinData.persistence.entity.CategoriaEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    // ENTITY -> DTO
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "descripcion", target = "descripcion")
    @Mapping(source = "estado", target = "estado")
    public CategoriaDto toDto(CategoriaEntity entity);

    // Lista de Entity -> Lista de DTO
    public List<CategoriaDto> toDto(Iterable<CategoriaEntity> entities);

    // DTO -> ENTITY
    @InheritInverseConfiguration
    CategoriaEntity toEntity(CategoriaDto dto);

    // Modificar ENTITY con un ModCategoriaDto
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "descripcion", target = "descripcion")
    @Mapping(source = "estado", target = "estado")
    @Mapping(target = "id", ignore = true)  // Importante: Ignora el ID para evitar errores
    void modificarEntityFromDto(ModCategoriaDto modCategoriaDto, @MappingTarget CategoriaEntity categoriaEntity);
}