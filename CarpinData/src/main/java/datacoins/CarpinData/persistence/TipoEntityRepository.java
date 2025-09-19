package datacoins.CarpinData.persistence;

import datacoins.CarpinData.dominio.dto.ModTipoDto;
import datacoins.CarpinData.dominio.dto.TipoDto;
import datacoins.CarpinData.dominio.exception.TipoNoExisteException;
import datacoins.CarpinData.dominio.exception.TipoYaExisteException;
import datacoins.CarpinData.dominio.repository.TipoRepository;
import datacoins.CarpinData.persistence.crud.CrudTipoEntity;
import datacoins.CarpinData.persistence.entity.TipoEntity;
import datacoins.CarpinData.web.mapper.TipoMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TipoEntityRepository implements TipoRepository {

    private final CrudTipoEntity crudTipo;
    private final TipoMapper tipoMapper;

    public TipoEntityRepository(CrudTipoEntity crudTipo, TipoMapper tipoMapper) {
        this.crudTipo = crudTipo;
        this.tipoMapper = tipoMapper;
    }

    // Obtiene todos los tipos de la base de datos
    @Override
    public List<TipoDto> obtenerTodo() {
        return this.tipoMapper.toDto(this.crudTipo.findAll());
    }

    // Busca un tipo por su ID
    @Override
    public TipoDto obtenerTipoPorId(Long id) {
        TipoEntity tipoEntity = this.crudTipo.findById(id).orElse(null);
        if (tipoEntity == null) throw new TipoNoExisteException(id);
        return this.tipoMapper.toDto(tipoEntity);
    }

    // Guarda un nuevo tipo en la base de datos
    // Validación: no se permite registrar dos tipos con el mismo nombre
    @Override
    public TipoDto guardarTipo(TipoDto tipoDto) {
        if (this.crudTipo.findFirstByNombre(tipoDto.nombre()) != null) {
            throw new TipoYaExisteException(tipoDto.nombre());
        }

        TipoEntity tipoEntity = this.tipoMapper.toEntity(tipoDto);
        this.crudTipo.save(tipoEntity);
        return this.tipoMapper.toDto(tipoEntity);
    }

    // Modifica un tipo existente
    @Override
    public TipoDto modificarTipo(Long id, ModTipoDto modTipoDto) {
        TipoEntity tipoEntity = this.crudTipo.findById(id).orElse(null);
        if (tipoEntity == null) throw new TipoNoExisteException(id);

        this.tipoMapper.modificarEntityFromDto(modTipoDto, tipoEntity);
        return this.tipoMapper.toDto(this.crudTipo.save(tipoEntity));
    }

    // Elimina un tipo por su ID
    @Override
    public void eliminarTipo(Long id) {
        TipoEntity tipoEntity = this.crudTipo.findById(id).orElse(null);
        if (tipoEntity == null) throw new TipoNoExisteException(id);

        this.crudTipo.delete(tipoEntity);
    }
}