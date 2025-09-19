package datacoins.CarpinData.web.controller;

import datacoins.CarpinData.dominio.dto.CategoriaDto;
import datacoins.CarpinData.dominio.dto.ModCategoriaDto;
import datacoins.CarpinData.dominio.service.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/categorias")
@Tag(name = "Categorías", description = "Operaciones CRUD sobre las categorías de CarpinData")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    @Operation(
            summary = "Obtener todas las categorías",
            description = "Retorna una lista con todas las categorías registradas",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Listado obtenido exitosamente")
            }
    )
    public ResponseEntity<List<CategoriaDto>> obtenerTodo() {
        return ResponseEntity.ok(this.categoriaService.obtenerTodo());
    }

    @GetMapping("{codigo}")
    @Operation(
            summary = "Obtener una categoría por su código",
            description = "Retorna la categoría que coincide con el identificador proporcionado",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Categoría encontrada exitosamente"),
                    @ApiResponse(responseCode = "404", description = "Categoría no encontrada", content = @Content)
            }
    )
    public ResponseEntity<CategoriaDto> obtenerCategoriaPorCodigo(
            @Parameter(description = "Código único de la categoría", example = "3")
            @PathVariable Long codigo) {
        return ResponseEntity.ok(this.categoriaService.obtenerCategoriaPorCodigo(codigo));
    }

    @PostMapping
    @Operation(
            summary = "Crear una nueva categoría",
            description = "Registra una nueva categoría en el sistema",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Categoría creada exitosamente"),
                    @ApiResponse(responseCode = "409", description = "Ya existe una categoría con ese nombre", content = @Content)
            }
    )
    public ResponseEntity<CategoriaDto> guardarCategoria(
            @Valid @RequestBody CategoriaDto categoriaDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.categoriaService.guardarCategotis(categoriaDto));
    }

    @PutMapping("{codigo}")
    @Operation(
            summary = "Modificar una categoría existente",
            description = "Actualiza los datos de una categoría con el código proporcionado",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Categoría actualizada exitosamente"),
                    @ApiResponse(responseCode = "404", description = "Categoría no encontrada", content = @Content),
                    @ApiResponse(responseCode = "409", description = "Ya existe otra categoría con ese nombre", content = @Content)
            }
    )
    public ResponseEntity<CategoriaDto> modificarCategoria(
            @Parameter(description = "Código de la categoría a modificar", example = "2")
            @PathVariable Long codigo,
            @Valid @RequestBody ModCategoriaDto modCategoriaDto) {
        return ResponseEntity.ok(this.categoriaService.modificarCategoria(codigo, modCategoriaDto));
    }

    @DeleteMapping("{codigo}")
    @Operation(
            summary = "Eliminar una categoría",
            description = "Elimina una categoría por su código único",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Categoría eliminada exitosamente"),
                    @ApiResponse(responseCode = "404", description = "Categoría no encontrada", content = @Content)
            }
    )
    public ResponseEntity<Void> eliminarCategoria(
            @Parameter(description = "Código de la categoría a eliminar", example = "4")
            @PathVariable Long codigo) {
        this.categoriaService.eliminarCategoria(codigo);
        return ResponseEntity.ok().build();
    }
}
