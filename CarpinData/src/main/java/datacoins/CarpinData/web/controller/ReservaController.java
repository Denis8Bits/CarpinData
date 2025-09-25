package datacoins.CarpinData.web.controller;

import datacoins.CarpinData.dominio.dto.ReservaDto;
import datacoins.CarpinData.dominio.dto.ModReservaDto;
import datacoins.CarpinData.dominio.service.ReservaService;
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
@RequestMapping("/v1/reservas")
@Tag(name = "Reservas", description = "Operaciones CRUD sobre las reservas de CarpinData")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping
    @Operation(
            summary = "Obtener todas las reservas",
            description = "Retorna una lista con todas las reservas registradas",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Listado obtenido exitosamente")
            }
    )
    public ResponseEntity<List<ReservaDto>> obtenerTodo() {
        return ResponseEntity.ok(this.reservaService.obtenerTodo());
    }

    @GetMapping("{id}")
    @Operation(
            summary = "Obtener una reserva por su ID",
            description = "Retorna la reserva que coincide con el identificador proporcionado",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Reserva encontrada exitosamente"),
                    @ApiResponse(responseCode = "404", description = "Reserva no encontrada", content = @Content)
            }
    )
    public ResponseEntity<ReservaDto> obtenerReservaPorId(
            @Parameter(description = "ID único de la reserva", example = "3")
            @PathVariable Long id) {
        return ResponseEntity.ok(this.reservaService.obtenerReservaPorId(id));
    }

    @PostMapping
    @Operation(
            summary = "Crear una nueva reserva",
            description = "Registra una nueva reserva en el sistema",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Reserva creada exitosamente"),
                    @ApiResponse(responseCode = "409", description = "Ya existe una reserva activa para este usuario y mueble", content = @Content)
            }
    )
    public ResponseEntity<ReservaDto> guardarReserva(
            @Valid @RequestBody ReservaDto reservaDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.reservaService.guardarReserva(reservaDto));
    }

    @PutMapping("{id}")
    @Operation(
            summary = "Modificar una reserva existente",
            description = "Actualiza los datos de una reserva con el ID proporcionado",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Reserva actualizada exitosamente"),
                    @ApiResponse(responseCode = "404", description = "Reserva no encontrada", content = @Content)
            }
    )
    public ResponseEntity<ReservaDto> modificarReserva(
            @Parameter(description = "ID de la reserva a modificar", example = "2")
            @PathVariable Long id,
            @Valid @RequestBody ModReservaDto modReservaDto) {
        return ResponseEntity.ok(this.reservaService.modificarReserva(id, modReservaDto));
    }

    @DeleteMapping("{id}")
    @Operation(
            summary = "Eliminar una reserva",
            description = "Elimina una reserva por su ID único",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Reserva eliminada exitosamente"),
                    @ApiResponse(responseCode = "404", description = "Reserva no encontrada", content = @Content)
            }
    )
    public ResponseEntity<Void> eliminarReserva(
            @Parameter(description = "ID de la reserva a eliminar", example = "4")
            @PathVariable Long id) {
        this.reservaService.eliminarReserva(id);
        return ResponseEntity.ok().build();
    }
}