package datacoins.CarpinData.web.controller;

import datacoins.CarpinData.dominio.dto.ModMuebleDto;
import datacoins.CarpinData.dominio.dto.MuebleDto;
import datacoins.CarpinData.dominio.service.MuebleService;
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

/**
 * Controlador REST para la gestión de muebles.
 */
@RestController
@RequestMapping("/v1/muebles")
@Tag(name = "Muebles", description = "Operaciones CRUD para la gestión de muebles")
public class MuebleController {

    private final MuebleService muebleService;

    public MuebleController(MuebleService muebleService) {
        this.muebleService = muebleService;
    }

    @GetMapping
    @Operation(
            summary = "Obtener todos los muebles",
            description = "Devuelve una lista con todos los muebles registrados en el sistema",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Lista de muebles obtenida con éxito")
            }
    )
    public ResponseEntity<List<MuebleDto>> obtenerTodo() {
        return ResponseEntity.ok(this.muebleService.obtenerTodo());
    }

    @GetMapping("{codigo}")
    @Operation(
            summary = "Obtener mueble por código",
            description = "Obtiene los datos de un mueble específico por su identificador único",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Mueble encontrado exitosamente"),
                    @ApiResponse(responseCode = "404", description = "Mueble no encontrado", content = @Content)
            }
    )
    public ResponseEntity<MuebleDto> obtenerMueblePorCodigo(
            @Parameter(description = "Código único del mueble", example = "1")
            @PathVariable Long codigo
    ) {
        return ResponseEntity.ok(this.muebleService.obtenerMueblePorCodigo(codigo));
    }

    @PostMapping
    @Operation(
            summary = "Registrar nuevo mueble",
            description = "Crea un nuevo mueble con los datos proporcionados",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Mueble creado exitosamente"),
                    @ApiResponse(responseCode = "400", description = "Datos inválidos o mueble duplicado", content = @Content)
            }
    )
    public ResponseEntity<MuebleDto> guardarMueble(
            @Valid @RequestBody MuebleDto muebleDto
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.muebleService.guardarMueble(muebleDto));
    }

    @PutMapping("{codigo}")
    @Operation(
            summary = "Modificar un mueble existente",
            description = "Actualiza los datos de un mueble existente usando su código",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Mueble actualizado correctamente"),
                    @ApiResponse(responseCode = "404", description = "Mueble no encontrado", content = @Content)
            }
    )
    public ResponseEntity<MuebleDto> modificarMueble(
            @Parameter(description = "Código del mueble a modificar", example = "3")
            @PathVariable Long codigo,

            @Valid @RequestBody ModMuebleDto modMuebleDto
    ) {
        return ResponseEntity.ok(this.muebleService.modificarMueble(codigo, modMuebleDto));
    }

    @DeleteMapping("{codigo}")
    @Operation(
            summary = "Eliminar un mueble",
            description = "Elimina un mueble del sistema por su código",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Mueble eliminado exitosamente"),
                    @ApiResponse(responseCode = "404", description = "Mueble no encontrado", content = @Content)
            }
    )
    public ResponseEntity<Void> eliminarMueble(
            @Parameter(description = "Código del mueble a eliminar", example = "5")
            @PathVariable Long codigo
    ) {
        this.muebleService.eliminarMueble(codigo);
        return ResponseEntity.ok().build();
    }
}
