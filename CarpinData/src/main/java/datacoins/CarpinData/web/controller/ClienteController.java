package datacoins.CarpinData.web.controller;

import datacoins.CarpinData.dominio.dto.ClienteDto;
import datacoins.CarpinData.dominio.dto.ModClienteDto;
import datacoins.CarpinData.dominio.service.ClienteService;
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
@RequestMapping("/v1/clientes")
@Tag(name = "Clientes", description = "Operaciones CRUD sobre los clientes de CarpinData")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    @Operation(
            summary = "Obtener todos los clientes",
            description = "Retorna una lista con todos los clientes registrados",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Listado de clientes obtenido exitosamente")
            }
    )
    public ResponseEntity<List<ClienteDto>> obtenerTodo() {
        return ResponseEntity.ok(this.clienteService.obtenerTodo());
    }

    @GetMapping("{codigo}")
    @Operation(
            summary = "Obtener un cliente por su código",
            description = "Retorna el cliente que coincide con el código proporcionado",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Cliente encontrado exitosamente"),
                    @ApiResponse(responseCode = "404", description = "Cliente no encontrado", content = @Content)
            }
    )
    public ResponseEntity<ClienteDto> obtenerClientePorCodigo(
            @Parameter(description = "Código único del cliente", example = "3")
            @PathVariable Long codigo) {
        ClienteDto cliente = this.clienteService.obtenerClientePorCodigo(codigo);
        if (cliente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(cliente);
    }

    @PostMapping
    @Operation(
            summary = "Crear un nuevo cliente",
            description = "Registra un nuevo cliente en el sistema",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Cliente creado exitosamente"),
                    @ApiResponse(responseCode = "409", description = "Ya existe un cliente con ese código", content = @Content)
            }
    )
    public ResponseEntity<ClienteDto> guardarCliente(
            @Valid @RequestBody ClienteDto clienteDto) {
        ClienteDto nuevoCliente = this.clienteService.guardarCliente(clienteDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCliente);
    }

    @PutMapping("{codigo}")
    @Operation(
            summary = "Modificar un cliente existente",
            description = "Actualiza los datos de un cliente con el código proporcionado",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Cliente actualizado exitosamente"),
                    @ApiResponse(responseCode = "404", description = "Cliente no encontrado", content = @Content),
                    @ApiResponse(responseCode = "409", description = "Ya existe un cliente con ese código", content = @Content)
            }
    )
    public ResponseEntity<ClienteDto> modificarCliente(
            @Parameter(description = "Código del cliente a modificar", example = "2")
            @PathVariable Long codigo,
            @Valid @RequestBody ModClienteDto modClienteDto) {
        ClienteDto clienteModificado = this.clienteService.modificarCliente(codigo, modClienteDto);
        if (clienteModificado == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(clienteModificado);
    }

    @DeleteMapping("{codigo}")
    @Operation(
            summary = "Eliminar un cliente",
            description = "Elimina un cliente por su código único",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Cliente eliminado exitosamente"),
                    @ApiResponse(responseCode = "404", description = "Cliente no encontrado", content = @Content)
            }
    )
    public ResponseEntity<Void> eliminarCliente(
            @Parameter(description = "Código del cliente a eliminar", example = "4")
            @PathVariable Long codigo) {
        if (this.clienteService.eliminarCliente(codigo)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
