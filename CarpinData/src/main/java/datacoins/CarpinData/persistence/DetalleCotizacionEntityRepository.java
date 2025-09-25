package datacoins.CarpinData.persistence;

import datacoins.CarpinData.dominio.dto.ModDetalleCotizacionDto;
import datacoins.CarpinData.dominio.dto.DetalleCotizacionDto;
import datacoins.CarpinData.dominio.exception.DetalleCotizacionNoExisteException;
import datacoins.CarpinData.dominio.exception.DetalleCotizacionYaExisteException;
import datacoins.CarpinData.dominio.repository.DetalleCotizacionRepository;
import datacoins.CarpinData.persistence.crud.CrudDetalleCotizacionEntity;
import datacoins.CarpinData.persistence.entity.DetalleCotizacionEntity;
import datacoins.CarpinData.web.mapper.DetalleCotizacionMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DetalleCotizacionEntityRepository implements DetalleCotizacionRepository {

    private final CrudDetalleCotizacionEntity crudDetalleCotizacion;
    private final DetalleCotizacionMapper detalleCotizacionMapper;

    public DetalleCotizacionEntityRepository(CrudDetalleCotizacionEntity crudDetalleCotizacion, DetalleCotizacionMapper detalleCotizacionMapper) {
        this.crudDetalleCotizacion = crudDetalleCotizacion;
        this.detalleCotizacionMapper = detalleCotizacionMapper;
    }

    @Override
    public List<DetalleCotizacionDto> obtenerTodo() {
        return this.detalleCotizacionMapper.toDto(this.crudDetalleCotizacion.findAll());
    }

    @Override
    public DetalleCotizacionDto obtenerDetalleCotizacionPorCodigo(Long codigo) {
        DetalleCotizacionEntity detalleCotizacionEntity = this.crudDetalleCotizacion.findById(codigo).orElse(null);
        if (detalleCotizacionEntity == null) {
            throw new DetalleCotizacionNoExisteException(codigo);
        }
        return this.detalleCotizacionMapper.toDto(detalleCotizacionEntity);
    }

    @Override
    public DetalleCotizacionDto guardarDetalleCotizacion(DetalleCotizacionDto detalleCotizacionDto) {
        // Validar si ya existe un detalle de cotización con el mismo id_cotizacion
        if (this.crudDetalleCotizacion.findFirstByIdCotizacion(detalleCotizacionDto.idCotizacion()) != null) {
            throw new DetalleCotizacionYaExisteException(detalleCotizacionDto.idCotizacion());
        }

        DetalleCotizacionEntity detalleCotizacionEntity = this.detalleCotizacionMapper.toEntity(detalleCotizacionDto);
        DetalleCotizacionEntity savedEntity = this.crudDetalleCotizacion.save(detalleCotizacionEntity);
        return this.detalleCotizacionMapper.toDto(savedEntity);
    }

    @Override
    public DetalleCotizacionDto modificarDetalleCotizacion(Long codigo, ModDetalleCotizacionDto modDetalleCotizacionDto) {
        DetalleCotizacionEntity detalleCotizacionEntity = this.crudDetalleCotizacion.findById(codigo).orElse(null);
        if (detalleCotizacionEntity == null) {
            throw new DetalleCotizacionNoExisteException(codigo);
        }

        // Check if the new id_cotizacion already exists in another detalle cotización
        DetalleCotizacionEntity existingDetalleWithCotizacion = this.crudDetalleCotizacion.findFirstByIdCotizacion(modDetalleCotizacionDto.idCotizacion());
        if (existingDetalleWithCotizacion != null && !existingDetalleWithCotizacion.getId().equals(codigo)) {
            throw new DetalleCotizacionYaExisteException(modDetalleCotizacionDto.idCotizacion());
        }

        // Update the entity with the new data (the mapper will ignore the ID)
        this.detalleCotizacionMapper.modificarEntityFromDto(modDetalleCotizacionDto, detalleCotizacionEntity);

        DetalleCotizacionEntity savedEntity = this.crudDetalleCotizacion.save(detalleCotizacionEntity);
        return this.detalleCotizacionMapper.toDto(savedEntity);
    }

    @Override
    public void eliminarDetalleCotizacion(Long codigo) {
        DetalleCotizacionEntity detalleCotizacionEntity = this.crudDetalleCotizacion.findById(codigo).orElse(null);
        if (detalleCotizacionEntity == null) {
            throw new DetalleCotizacionNoExisteException(codigo);
        }
        this.crudDetalleCotizacion.delete(detalleCotizacionEntity);
    }
}