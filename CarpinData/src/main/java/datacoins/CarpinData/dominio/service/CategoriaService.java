package datacoins.CarpinData.dominio.service;

import datacoins.CarpinData.dominio.dto.CategoriaDto;
import datacoins.CarpinData.dominio.dto.ModCategoriaDto;
import datacoins.CarpinData.dominio.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;


    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<CategoriaDto> obtenerTodo(){
        return this.categoriaRepository.obtenerTodo();
    }

    public CategoriaDto obtenerCategoriaPorCodigo(Long codigo){
        return this.categoriaRepository.obtenerCategoriaPorCodigo(codigo);
    }

    public CategoriaDto guardarCategotis(CategoriaDto categoriaDto){
        return this.categoriaRepository.guardarCategoria(categoriaDto);
    }

    public CategoriaDto modificarCategoria(Long codigo, ModCategoriaDto modCategoriaDto){
        return this.categoriaRepository.modificarCategoria(codigo, modCategoriaDto);
    }

    public void eliminarCategoria(Long codigo){
        this.categoriaRepository.eliminarCategoria(codigo);
    }
}


