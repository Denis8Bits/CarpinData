package datacoins.CarpinData.persistence;

import datacoins.CarpinData.dominio.dto.ModCotizacionDto;
import datacoins.CarpinData.dominio.dto.CotizacionDto;
import datacoins.CarpinData.dominio.exception.CotizacionNoExisteException;
import datacoins.CarpinData.dominio.exception.CotizacionYaExisteException;
import datacoins.CarpinData.dominio.repository.CotizacionRepository;
import datacoins.CarpinData.persistence.crud.CrudCotizacionEntity;
import datacoins.CarpinData.persistence.entity.CotizacionEntity;
import datacoins.CarpinData.web.mapper.CotizacionMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CotizacionEntityRepository implements CotizacionRepository {

    private final CrudCotizacionEntity crudCotizacion;
    private final CotizacionMapper cotizacionMapper;

    public CotizacionEntityRepository(CrudCotizacionEntity crudCotizacion, CotizacionMapper cotizacionMapper) {
        this.crudCotizacion = crudCotizacion;
        this.cotizacionMapper = cotizacionMapper;
    }

    @Override
    public List<CotizacionDto> obtenerTodo() {
        return this.cotizacionMapper.toDto(this.crudCotizacion.findAll());
    }

    @Override
    public CotizacionDto obtenerCotizacionPorCodigo(Long codigo) {
        CotizacionEntity cotizacionEntity = this.crudCotizacion.findById(codigo).orElse(null);
        if (cotizacionEntity == null) {
            throw new CotizacionNoExisteException(codigo);
        }
        return this.cotizacionMapper.toDto(cotizacionEntity);
    }

    @Override
    public CotizacionDto guardarCotizacion(CotizacionDto cotizacionDto) {
        // Validar si ya existe una cotización con la misma cantidad
        if (this.crudCotizacion.findFirstByCantidad(cotizacionDto.cantidad()) != null) {
            throw new CotizacionYaExisteException(cotizacionDto.cantidad());
        }

        CotizacionEntity cotizacionEntity = this.cotizacionMapper.toEntity(cotizacionDto);
        CotizacionEntity savedEntity = this.crudCotizacion.save(cotizacionEntity);
        return this.cotizacionMapper.toDto(savedEntity);
    }

    @Override
    public CotizacionDto modificarCotizacion(Long codigo, ModCotizacionDto modCotizacionDto) {
        CotizacionEntity cotizacionEntity = this.crudCotizacion.findById(codigo).orElse(null);
        if (cotizacionEntity == null) {
            throw new CotizacionNoExisteException(codigo);
        }

        // Verificar si la nueva cantidad ya existe en otra cotización
        CotizacionEntity existingCotizacionWithCantidad = this.crudCotizacion.findFirstByCantidad(modCotizacionDto.cantidad());
        if (existingCotizacionWithCantidad != null && !existingCotizacionWithCantidad.getId().equals(codigo)) {
            throw new CotizacionYaExisteException(modCotizacionDto.cantidad());
        }

        // Actualizar la entidad con los nuevos datos
        this.cotizacionMapper.modificarEntityFromDto(modCotizacionDto, cotizacionEntity);

        CotizacionEntity savedEntity = this.crudCotizacion.save(cotizacionEntity);
        return this.cotizacionMapper.toDto(savedEntity);
    }

    @Override
    public void eliminarCotizacion(Long codigo) {
        CotizacionEntity cotizacionEntity = this.crudCotizacion.findById(codigo).orElse(null);
        if (cotizacionEntity == null) {
            throw new CotizacionNoExisteException(codigo);
        }
        this.crudCotizacion.delete(cotizacionEntity);
    }
}