package datacoins.CarpinData.web.mapper;

import datacoins.CarpinData.dominio.dto.ModCotizacionDto;
import datacoins.CarpinData.dominio.dto.CotizacionDto;
import datacoins.CarpinData.persistence.entity.CotizacionEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CotizacionMapper {

    // Convertir Entity -> DTO
    @Mapping(source = "cantidad", target = "cantidad")
    @Mapping(source = "total", target = "total")
    @Mapping(source = "descripcion", target = "descripcion")
    CotizacionDto toDto(CotizacionEntity entity);

    List<CotizacionDto> toDto(Iterable<CotizacionEntity> entities);

    // Convertir DTO -> Entity
    @InheritInverseConfiguration
    CotizacionEntity toEntity(CotizacionDto cotizacionDto);

    @Mapping(source = "cantidad", target = "cantidad")
    @Mapping(source = "total", target = "total")
    @Mapping(source = "descripcion", target = "descripcion")
    @Mapping(target = "id", ignore = true)
    void modificarEntityFromDto(ModCotizacionDto modCotizacionDto, @MappingTarget CotizacionEntity cotizacionEntity);
}