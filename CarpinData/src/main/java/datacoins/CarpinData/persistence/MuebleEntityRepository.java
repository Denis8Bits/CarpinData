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

/**
 * Implementación de {@link MuebleRepository} usando JPA/Hibernate.
 *
 * - Se encarga de interactuar con la base de datos mediante {@link CrudMuebleEntity}.
 * - Convierte entidades de persistencia ({@link MuebleEntity}) a DTOs ({@link MuebleDto})
 *   y viceversa usando {@link MuebleMapper}.
 *
 * Validaciones implementadas:
 * - Verifica existencia de muebles por ID antes de modificar/eliminar.
 * - Verifica unicidad de un campo (color) antes de guardar un nuevo mueble.
 *
 * Excepciones lanzadas:
 * - {@link MuebleNoExisteException} → cuando no se encuentra un mueble con el ID solicitado.
 * - {@link MuebleYaExisteException} → cuando ya existe un mueble con el mismo color.
 */
@Repository
public class MuebleEntityRepository implements MuebleRepository {

    private final CrudMuebleEntity crudMueble;
    private final MuebleMapper muebleMapper;

    public MuebleEntityRepository(CrudMuebleEntity crudMueble, MuebleMapper muebleMapper) {
        this.crudMueble = crudMueble;
        this.muebleMapper = muebleMapper;
    }

    /**
     * Obtiene todos los muebles de la base de datos.
     *
     * @return lista de {@link MuebleDto}.
     */
    @Override
    public List<MuebleDto> obtenerTodo() {
        return this.muebleMapper.toDto(this.crudMueble.findAll());
    }

    /**
     * Busca un mueble por su ID.
     *
     * @param codigo ID del mueble.
     * @return {@link MuebleDto} del mueble encontrado.
     * @throws MuebleNoExisteException si no se encuentra un mueble con ese código.
     */
    @Override
    public MuebleDto obtenerMueblePorCodigo(Long codigo) {
        MuebleEntity muebleEntity = this.crudMueble.findById(codigo).orElse(null);
        if (muebleEntity == null) throw new MuebleNoExisteException(codigo);
        return this.muebleMapper.toDto(muebleEntity);
    }

    /**
     * Guarda un nuevo mueble en la base de datos.
     *
     * Validación: no se permite registrar dos muebles con el mismo color.
     *
     * @param muebleDto datos del nuevo mueble.
     * @return {@link MuebleDto} con los datos persistidos.
     * @throws MuebleYaExisteException si ya existe un mueble con el mismo color.
     */
    @Override
    public MuebleDto guardarMueble(MuebleDto muebleDto) {
        // Validar si ya existe un mueble con el mismo color (campo único definido como ejemplo).
        if (this.crudMueble.findFirstByColor(muebleDto.color()) != null) {
            throw new MuebleYaExisteException(muebleDto.color());
        }

        MuebleEntity muebleEntity = this.muebleMapper.toEntity(muebleDto);
        this.crudMueble.save(muebleEntity);
        return this.muebleMapper.toDto(muebleEntity);
    }

    /**
     * Modifica un mueble existente.
     *
     * @param codigo       ID del mueble a modificar.
     * @param modMuebleDto datos modificados (parciales).
     * @return {@link MuebleDto} actualizado.
     * @throws MuebleNoExisteException si el mueble no existe.
     */
    @Override
    public MuebleDto modificarMueble(Long codigo, ModMuebleDto modMuebleDto) {
        MuebleEntity muebleEntity = this.crudMueble.findById(codigo).orElse(null);
        if (muebleEntity == null) throw new MuebleNoExisteException(codigo);

        this.muebleMapper.modificarEntityFromDto(modMuebleDto, muebleEntity);
        return this.muebleMapper.toDto(this.crudMueble.save(muebleEntity));
    }

    /**
     * Elimina un mueble por su ID.
     *
     * @param codigo ID del mueble a eliminar.
     * @throws MuebleNoExisteException si el mueble no existe.
     */
    @Override
    public void eliminarMueble(Long codigo) {
        MuebleEntity muebleEntity = this.crudMueble.findById(codigo).orElse(null);
        if (muebleEntity == null) throw new MuebleNoExisteException(codigo);

        this.crudMueble.delete(muebleEntity);
    }
}
