package datacoins.CarpinData.web.mapper;

import datacoins.CarpinData.dominio.dto.ClienteDto;
import datacoins.CarpinData.persistence.entity.ClienteEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    //ENTITY -> DTO
    @Mapping(source = "codigo", target = "codigo")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "apellido", target = "apellido")
    @Mapping(source = "telefono", target = "telefono")
    @Mapping(source = "genero", target = "genero")
    @Mapping(source = "fechaNacimiento", target = "fechaNacimiento")
    @Mapping(source = "correo", target = "correo")
    @Mapping(source = "contraseña", target = "contraseña")
    ClienteDto toDto(ClienteEntity entity);

    //Lista de entidades a lista de DTOs
    List<ClienteDto> toDto(Iterable<ClienteEntity> entities);

    //DTO -> ENTITY
    @InheritInverseConfiguration
    ClienteEntity toEntity(ClienteDto dto);

    //Modificar ENTITY con un ClienteDto
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "apellido", target = "apellido")
    @Mapping(source = "telefono", target = "telefono")
    @Mapping(source = "genero", target = "genero")
    @Mapping(source = "fechaNacimiento", target = "fechaNacimiento")
    @Mapping(source = "correo", target = "correo")
    @Mapping(source = "contraseña", target = "contraseña")
    @Mapping(target = "codigo", ignore = true)
    void modificarEntityFromDto(ClienteDto clienteDto, @MappingTarget ClienteEntity clienteEntity);
}
