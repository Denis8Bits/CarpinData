package datacoins.CarpinData.persistence;

import datacoins.CarpinData.dominio.dto.ModMuebleDto;
import datacoins.CarpinData.dominio.dto.MuebleDto;
import datacoins.CarpinData.dominio.exception.MuebleNoExisteException;
import datacoins.CarpinData.dominio.exception.MuebleYaExisteException;
import datacoins.CarpinData.dominio.repository.MuebleRepository;
import datacoins.CarpinData.persistence.crud.CrudMuebleEntity;
import datacoins.CarpinData.persistence.entity.MuebleEntity;
import datacoins.CarpinData.web.mapper.MuebleMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MuebleEntityRepository implements MuebleRepository {

    private final CrudMuebleEntity crudMueble;
    private final MuebleMapper muebleMapper;

    public MuebleEntityRepository(CrudMuebleEntity crudMueble, MuebleMapper muebleMapper) {
        this.crudMueble = crudMueble;
        this.muebleMapper = muebleMapper;
    }

    @Override
    public List<MuebleDto> obtenerTodo() {
        return this.muebleMapper.toDto(this.crudMueble.findAll());
    }

    @Override
    public MuebleDto obtenerMueblePorCodigo(Long codigo) {
        MuebleEntity muebleEntity = this.crudMueble.findById(codigo).orElse(null);
        if (muebleEntity == null) {
            throw new MuebleNoExisteException(codigo);
        }
        return this.muebleMapper.toDto(muebleEntity);
    }

    @Override
    public MuebleDto guardarMueble(MuebleDto muebleDto) {
        // Validar si ya existe un mueble con el mismo color
        if (this.crudMueble.findFirstByColor(muebleDto.color()) != null) {
            throw new MuebleYaExisteException(muebleDto.color());
        }

        MuebleEntity muebleEntity = this.muebleMapper.toEntity(muebleDto);
        MuebleEntity savedEntity = this.crudMueble.save(muebleEntity);
        return this.muebleMapper.toDto(savedEntity);
    }

    @Override
    public MuebleDto modificarMueble(Long codigo, ModMuebleDto modMuebleDto) {
        MuebleEntity muebleEntity = this.crudMueble.findById(codigo).orElse(null);
        if (muebleEntity == null) {
            throw new MuebleNoExisteException(codigo);
        }

        // Check if the new color already exists in another mueble
        MuebleEntity existingMuebleWithColor = this.crudMueble.findFirstByColor(modMuebleDto.color());
        if (existingMuebleWithColor != null && !existingMuebleWithColor.getId().equals(codigo)) {
            throw new MuebleYaExisteException(modMuebleDto.color());
        }

        // Update the entity with the new data (the mapper will ignore the ID)
        this.muebleMapper.modificarEntityFromDto(modMuebleDto, muebleEntity);

        MuebleEntity savedEntity = this.crudMueble.save(muebleEntity);
        return this.muebleMapper.toDto(savedEntity);
    }

    @Override
    public void eliminarMueble(Long codigo) {
        MuebleEntity muebleEntity = this.crudMueble.findById(codigo).orElse(null);
        if (muebleEntity == null) {
            throw new MuebleNoExisteException(codigo);
        }
        this.crudMueble.delete(muebleEntity);
    }
}