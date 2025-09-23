package datacoins.CarpinData.web.controller;

import datacoins.CarpinData.dominio.dto.ModCotizacionDto;
import datacoins.CarpinData.dominio.dto.CotizacionDto;
import datacoins.CarpinData.dominio.service.CotizacionService;
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
 * Controlador REST para la gestión de cotizaciones.
 */
@RestController
@RequestMapping("/v1/cotizaciones")
@Tag(name = "Cotizaciones", description = "Operaciones CRUD para la gestión de cotizaciones")
public class CotizacionController {

    private final CotizacionService cotizacionService;

    public CotizacionController(CotizacionService cotizacionService) {
        this.cotizacionService = cotizacionService;
    }

    @GetMapping
    @Operation(
            summary = "Obtener todas las cotizaciones",
            description = "Devuelve una lista con todas las cotizaciones registradas en el sistema",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Lista de cotizaciones obtenida con éxito")
            }
    )
    public ResponseEntity<List<CotizacionDto>> obtenerTodo() {
        return ResponseEntity.ok(this.cotizacionService.obtenerTodo());
    }

    @GetMapping("{codigo}")
    @Operation(
            summary = "Obtener cotización por código",
            description = "Obtiene los datos de una cotización específica por su identificador único",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Cotización encontrada exitosamente"),
                    @ApiResponse(responseCode = "404", description = "Cotización no encontrada", content = @Content)
            }
    )
    public ResponseEntity<CotizacionDto> obtenerCotizacionPorCodigo(
            @Parameter(description = "Código único de la cotización", example = "1")
            @PathVariable Long codigo
    ) {
        return ResponseEntity.ok(this.cotizacionService.obtenerCotizacionPorCodigo(codigo));
    }

    @PostMapping
    @Operation(
            summary = "Registrar nueva cotización",
            description = "Crea una nueva cotización con los datos proporcionados",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Cotización creada exitosamente"),
                    @ApiResponse(responseCode = "400", description = "Datos inválidos o cotización duplicada", content = @Content)
            }
    )
    public ResponseEntity<CotizacionDto> guardarCotizacion(
            @Valid @RequestBody CotizacionDto cotizacionDto
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.cotizacionService.guardarCotizacion(cotizacionDto));
    }

    @PutMapping("{codigo}")
    @Operation(
            summary = "Modificar una cotización existente",
            description = "Actualiza los datos de una cotización existente usando su código",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Cotización actualizada correctamente"),
                    @ApiResponse(responseCode = "404", description = "Cotización no encontrada", content = @Content)
            }
    )
    public ResponseEntity<CotizacionDto> modificarCotizacion(
            @Parameter(description = "Código de la cotización a modificar", example = "3")
            @PathVariable Long codigo,

            @Valid @RequestBody ModCotizacionDto modCotizacionDto
    ) {
        return ResponseEntity.ok(this.cotizacionService.modificarCotizacion(codigo, modCotizacionDto));
    }

    @DeleteMapping("{codigo}")
    @Operation(
            summary = "Eliminar una cotización",
            description = "Elimina una cotización del sistema por su código",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Cotización eliminada exitosamente"),
                    @ApiResponse(responseCode = "404", description = "Cotización no encontrada", content = @Content)
            }
    )
    public ResponseEntity<Void> eliminarCotizacion(
            @Parameter(description = "Código de la cotización a eliminar", example = "5")
            @PathVariable Long codigo
    ) {
        this.cotizacionService.eliminarCotizacion(codigo);
        return ResponseEntity.ok().build();
    }
}