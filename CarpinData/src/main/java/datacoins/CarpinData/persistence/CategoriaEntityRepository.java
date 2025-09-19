package datacoins.CarpinData.persistence;

import datacoins.CarpinData.dominio.dto.CategoriaDto;
import datacoins.CarpinData.dominio.dto.ModCategoriaDto;
import datacoins.CarpinData.dominio.exception.CategoriaNoExisteException;
import datacoins.CarpinData.dominio.exception.CategoriaYaExisteException;
import datacoins.CarpinData.dominio.repository.CategoriaRepository;
import datacoins.CarpinData.persistence.crud.CrudCategoriaEntity;
import datacoins.CarpinData.persistence.entity.CategoriaEntity;
import datacoins.CarpinData.web.mapper.CategoriaMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoriaEntityRepository implements CategoriaRepository {

    private final CrudCategoriaEntity crudCategoria;
    private final CategoriaMapper categoriaMapper;

    public CategoriaEntityRepository(CrudCategoriaEntity crudCategoria, CategoriaMapper categoriaMapper) {
        this.crudCategoria = crudCategoria;
        this.categoriaMapper = categoriaMapper;
    }

    @Override
    public List<CategoriaDto> obtenerTodo() {
        return this.categoriaMapper.toDto(this.crudCategoria.findAll());
    }

    @Override
    public CategoriaDto obtenerCategoriaPorCodigo(Long codigo) {
        CategoriaEntity categoriaEntity = this.crudCategoria.findById(codigo)
                .orElseThrow(() -> new CategoriaNoExisteException(codigo));
        return this.categoriaMapper.toDto(categoriaEntity);
    }

    @Override
    public CategoriaDto guardarCategoria(CategoriaDto categoriaDto) {
        if (this.crudCategoria.findFirstByNombre(categoriaDto.nombre()) != null) {
            throw new CategoriaYaExisteException(categoriaDto.nombre());
        }

        CategoriaEntity categoriaEntity = this.categoriaMapper.toEntity(categoriaDto);

        // Si no viene un estado válido, se asigna por defecto
        if (categoriaEntity.getEstado() == null || categoriaEntity.getEstado().isBlank()) {
            categoriaEntity.setEstado("ACTIVE"); // O "INACTIVE" según tu lógica de negocio
        }

        this.crudCategoria.save(categoriaEntity);
        return this.categoriaMapper.toDto(categoriaEntity);
    }

    @Override
    public CategoriaDto modificarCategoria(Long codigo, ModCategoriaDto modCategoriaDto) {
        CategoriaEntity categoriaEntity = this.crudCategoria.findById(codigo)
                .orElseThrow(() -> new CategoriaNoExisteException(codigo));

        CategoriaEntity categoriaExistente = this.crudCategoria.findFirstByNombre(modCategoriaDto.nombre());
        if (categoriaExistente != null && !categoriaExistente.getId().equals(codigo)) {
            throw new CategoriaYaExisteException(modCategoriaDto.nombre());
        }

        this.categoriaMapper.modificarEntityFromDto(modCategoriaDto, categoriaEntity);
        return this.categoriaMapper.toDto(this.crudCategoria.save(categoriaEntity));
    }

    @Override
    public void eliminarCategoria(Long codigo) {
        CategoriaEntity categoriaEntity = this.crudCategoria.findById(codigo)
                .orElseThrow(() -> new CategoriaNoExisteException(codigo));

        this.crudCategoria.delete(categoriaEntity);
    }
}
