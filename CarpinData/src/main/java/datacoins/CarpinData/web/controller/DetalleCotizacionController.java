package datacoins.CarpinData.web.controller;

import datacoins.CarpinData.dominio.dto.ModDetalleCotizacionDto;
import datacoins.CarpinData.dominio.dto.DetalleCotizacionDto;
import datacoins.CarpinData.dominio.service.DetalleCotizacionService;
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
 * Controlador REST para la gestión de detalle de cotizaciones.
 */
@RestController
@RequestMapping("/v1/detalle-cotizaciones")
@Tag(name = "Detalle Cotizaciones", description = "Operaciones CRUD para la gestión de detalles de cotizaciones")
public class DetalleCotizacionController {

    private final DetalleCotizacionService detalleCotizacionService;

    public DetalleCotizacionController(DetalleCotizacionService detalleCotizacionService) {
        this.detalleCotizacionService = detalleCotizacionService;
    }

    @GetMapping
    @Operation(
            summary = "Obtener todos los detalles de cotizaciones",
            description = "Devuelve una lista con todos los detalles de cotizaciones registrados en el sistema",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Lista de detalles de cotizaciones obtenida con éxito")
            }
    )
    public ResponseEntity<List<DetalleCotizacionDto>> obtenerTodo() {
        return ResponseEntity.ok(this.detalleCotizacionService.obtenerTodo());
    }

    @GetMapping("{codigo}")
    @Operation(
            summary = "Obtener detalle de cotización por código",
            description = "Obtiene los datos de un detalle de cotización específico por su identificador único",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Detalle de cotización encontrado exitosamente"),
                    @ApiResponse(responseCode = "404", description = "Detalle de cotización no encontrado", content = @Content)
            }
    )
    public ResponseEntity<DetalleCotizacionDto> obtenerDetalleCotizacionPorCodigo(
            @Parameter(description = "Código único del detalle de cotización", example = "1")
            @PathVariable Long codigo
    ) {
        return ResponseEntity.ok(this.detalleCotizacionService.obtenerDetalleCotizacionPorCodigo(codigo));
    }

    @PostMapping
    @Operation(
            summary = "Registrar nuevo detalle de cotización",
            description = "Crea un nuevo detalle de cotización con los datos proporcionados",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Detalle de cotización creado exitosamente"),
                    @ApiResponse(responseCode = "400", description = "Datos inválidos o detalle de cotización duplicado", content = @Content)
            }
    )
    public ResponseEntity<DetalleCotizacionDto> guardarDetalleCotizacion(
            @Valid @RequestBody DetalleCotizacionDto detalleCotizacionDto
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.detalleCotizacionService.guardarDetalleCotizacion(detalleCotizacionDto));
    }

    @PutMapping("{codigo}")
    @Operation(
            summary = "Modificar un detalle de cotización existente",
            description = "Actualiza los datos de un detalle de cotización existente usando su código",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Detalle de cotización actualizado correctamente"),
                    @ApiResponse(responseCode = "404", description = "Detalle de cotización no encontrado", content = @Content)
            }
    )
    public ResponseEntity<DetalleCotizacionDto> modificarDetalleCotizacion(
            @Parameter(description = "Código del detalle de cotización a modificar", example = "3")
            @PathVariable Long codigo,

            @Valid @RequestBody ModDetalleCotizacionDto modDetalleCotizacionDto
    ) {
        return ResponseEntity.ok(this.detalleCotizacionService.modificarDetalleCotizacion(codigo, modDetalleCotizacionDto));
    }

    @DeleteMapping("{codigo}")
    @Operation(
            summary = "Eliminar un detalle de cotización",
            description = "Elimina un detalle de cotización del sistema por su código",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Detalle de cotización eliminado exitosamente"),
                    @ApiResponse(responseCode = "404", description = "Detalle de cotización no encontrado", content = @Content)
            }
    )
    public ResponseEntity<Void> eliminarDetalleCotizacion(
            @Parameter(description = "Código del detalle de cotización a eliminar", example = "5")
            @PathVariable Long codigo
    ) {
        this.detalleCotizacionService.eliminarDetalleCotizacion(codigo);
        return ResponseEntity.ok().build();
    }
}