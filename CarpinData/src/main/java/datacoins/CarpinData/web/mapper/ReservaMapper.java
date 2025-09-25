package datacoins.CarpinData.web.mapper;

import datacoins.CarpinData.dominio.dto.ReservaDto;
import datacoins.CarpinData.dominio.dto.ModReservaDto;
import datacoins.CarpinData.persistence.entity.ReservaEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReservaMapper {

    // Entity -> DTO
    ReservaDto toDto(ReservaEntity entity);

    // Lista de Entity -> Lista de DTO
    List<ReservaDto> toDto(Iterable<ReservaEntity> entities);

    // DTO -> Entity
    @InheritInverseConfiguration
    ReservaEntity toEntity(ReservaDto dto);

    // Modificar Entity desde ModReservaDto
    @Mapping(source = "fechaReserva", target = "fechaReserva")
    @Mapping(source = "estado", target = "estado")
    @Mapping(source = "idUsuario", target = "idUsuario")
    @Mapping(source = "idMueble", target = "idMueble")
    void modificarEntityFromDto(ModReservaDto modDto, @MappingTarget ReservaEntity entity);
}