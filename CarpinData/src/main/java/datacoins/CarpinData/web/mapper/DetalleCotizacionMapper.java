package datacoins.CarpinData.web.mapper;

import datacoins.CarpinData.dominio.dto.ModDetalleCotizacionDto;
import datacoins.CarpinData.dominio.dto.DetalleCotizacionDto;
import datacoins.CarpinData.persistence.entity.DetalleCotizacionEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = "spring")
public interface DetalleCotizacionMapper {

    // Convertir Entity -> DTO
    @Mapping(source = "idMueble", target = "idMueble")
    @Mapping(source = "idCotizacion", target = "idCotizacion")
    DetalleCotizacionDto toDto(DetalleCotizacionEntity entity);

    List<DetalleCotizacionDto> toDto(Iterable<DetalleCotizacionEntity> entities);

    // Convertir DTO -> Entity
    @InheritInverseConfiguration
    DetalleCotizacionEntity toEntity(DetalleCotizacionDto detalleCotizacionDto);

    @Mapping(source = "idMueble", target = "idMueble")
    @Mapping(source = "idCotizacion", target = "idCotizacion")
    @Mapping(target = "id", ignore = true)
    void modificarEntityFromDto(ModDetalleCotizacionDto modDetalleCotizacionDto, @MappingTarget DetalleCotizacionEntity detalleCotizacionEntity);
}
