package datacoins.CarpinData.web.mapper;

import datacoins.CarpinData.dominio.dto.CategoriaDto;
import datacoins.CarpinData.dominio.dto.ModCategoriaDto;
import datacoins.CarpinData.persistence.entity.CategoriaEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = {EstadoMapper.class})
public interface CategoriaMapper {

    // Entity -> DTO
    @Mapping(source = "estado", target = "estado", qualifiedByName = "generarEstadoString")
    CategoriaDto toDto(CategoriaEntity entity);

    // Lista de Entity -> Lista de DTO
    List<CategoriaDto> toDto(Iterable<CategoriaEntity> entities);

    // DTO -> Entity
    @InheritInverseConfiguration
    @Mapping(source = "estado", target = "estado", qualifiedByName = "generarEstado")
    CategoriaEntity toEntity(CategoriaDto dto);

    // Modificar Entity desde ModCategoriaDto
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "descripcion", target = "descripcion")
    @Mapping(source = "estado", target = "estado", qualifiedByName = "generarEstado")
    void modificarEntityFromDto(ModCategoriaDto modDto, @MappingTarget CategoriaEntity entity);
}
