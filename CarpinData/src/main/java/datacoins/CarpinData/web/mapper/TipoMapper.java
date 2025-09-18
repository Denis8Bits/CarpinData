package datacoins.CarpinData.web.mapper;
import datacoins.CarpinData.dominio.dto.ModTipoDto;
import datacoins.CarpinData.dominio.dto.TipoDto;
import datacoins.CarpinData.persistence.entity.TipoEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TipoMapper {

    // Convertir Entity -> DTO
    @Mapping(source = "id", target = "id")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "descripcion", target = "descripcion")
    @Mapping(source = "estado", target = "estado")
    TipoDto toDto(TipoEntity entity);

    List<TipoDto> toDto(Iterable<TipoEntity> entities);

    // Convertir DTO -> Entity
    @InheritInverseConfiguration
    TipoEntity toEntity(TipoDto tipoDto);

    // Modificar Entity desde ModTipoDto
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "descripcion", target = "descripcion")
    @Mapping(source = "estado", target = "estado")
    void modificarEntityFromDto(ModTipoDto modTipoDto, @MappingTarget TipoEntity tipoEntity);
}