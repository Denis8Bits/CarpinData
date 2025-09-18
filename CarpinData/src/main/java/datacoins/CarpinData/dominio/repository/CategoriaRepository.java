package datacoins.CarpinData.dominio.repository;

import datacoins.CarpinData.dominio.dto.CategoriaDto;
import datacoins.CarpinData.dominio.dto.ModCategoriaDto;

import java.util.List;

public interface CategoriaRepository {
    List<CategoriaDto> obtenerTodo();
    CategoriaDto obtenerCategoriaPorCodigo(Long codigo);
    CategoriaDto guardarCategoria(CategoriaDto categoriaDto);
    CategoriaDto modificarCategoria(Long codigo, ModCategoriaDto categoriaDto);
    void eliminarCategoria(Long codigo);
}

