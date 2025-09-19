package datacoins.CarpinData.web.mapper;

import datacoins.CarpinData.dominio.dto.ModMuebleDto;
import datacoins.CarpinData.dominio.dto.MuebleDto;
import datacoins.CarpinData.persistence.entity.MuebleEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = "spring")
public interface MuebleMapper {

    // Convertir Entity -> DTO
    @Mapping(source = "color", target = "color")
    @Mapping(source = "tamaño", target = "tamaño")
    @Mapping(source = "estilo", target = "estilo")
    MuebleDto toDto(MuebleEntity entity);

    List<MuebleDto> toDto(Iterable<MuebleEntity> entities);

    // Convertir DTO -> Entity
    @InheritInverseConfiguration
    MuebleEntity toEntity(MuebleDto muebleDto);

    @Mapping(source = "color", target = "color")
    @Mapping(source = "tamaño", target = "tamaño")
    @Mapping(source = "estilo", target = "estilo")
    @Mapping(target = "id", ignore = true)
    void modificarEntityFromDto(ModMuebleDto modMuebleDto, @MappingTarget MuebleEntity muebleEntity);
}