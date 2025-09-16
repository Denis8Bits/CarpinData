package datacoins.CarpinData.web.controller;

import datacoins.CarpinData.dominio.dto.ModMuebleDto;
import datacoins.CarpinData.dominio.dto.MuebleDto;
import datacoins.CarpinData.dominio.service.MuebleService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para la gestión de muebles.
 * Expone endpoints CRUD (crear, leer, actualizar, eliminar).
 */
@RestController
@RequestMapping("/v1/muebles")
public class MuebleController {

    private final MuebleService muebleService;

    public MuebleController(MuebleService muebleService) {
        this.muebleService = muebleService;
    }

    /**
     * Obtiene la lista completa de muebles.
     *
     * @return Lista de {@link MuebleDto} con todos los muebles registrados.
     * Respuestas:
     * - 200: OK, devuelve la lista de muebles.
     */
    @GetMapping
    public ResponseEntity<List<MuebleDto>> obtenerTodo() {
        return ResponseEntity.ok(this.muebleService.obtenerTodo());
    }

    /**
     * Obtiene un mueble por su código único.
     *
     * @param codigo Código del mueble a buscar.
     * @return {@link MuebleDto} con los datos del mueble.
     * Respuestas:
     * - 200: OK, mueble encontrado.
     * - 400/404: Mueble no existe (capturado en ExceptionHandler).
     */
    @GetMapping("{codigo}")
    public ResponseEntity<MuebleDto> obtenerMueblePorCodigo(@PathVariable Long codigo) {
        return ResponseEntity.ok(this.muebleService.obtenerMueblePorCodigo(codigo));
    }

    /**
     * Crea un nuevo mueble.
     *
     * @param muebleDto Datos del mueble a registrar (validados).
     * @return {@link MuebleDto} con los datos del mueble creado.
     * Respuestas:
     * - 201: Creado correctamente.
     * - 400: Datos inválidos o mueble duplicado.
     */
    @PostMapping
    public ResponseEntity<MuebleDto> guardarMueble(@Valid @RequestBody MuebleDto muebleDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.muebleService.guardarMueble(muebleDto));
    }

    /**
     * Modifica un mueble existente.
     *
     * @param codigo       Código del mueble a modificar.
     * @param modMuebleDto Datos nuevos del mueble (validados).
     * @return {@link MuebleDto} actualizado.
     * Respuestas:
     * - 200: OK, mueble actualizado.
     * - 400/404: Datos inválidos o mueble no encontrado.
     */
    @PutMapping("{codigo}")
    public ResponseEntity<MuebleDto> modificarMueble(
            @PathVariable Long codigo,
            @Valid @RequestBody ModMuebleDto modMuebleDto) {
        return ResponseEntity.ok(this.muebleService.modificarMueble(codigo, modMuebleDto));
    }

    /**
     * Elimina un mueble existente por su código.
     *
     * @param codigo Código del mueble a eliminar.
     * @return 200 OK si se eliminó correctamente.
     * Respuestas:
     * - 200: Eliminado correctamente.
     * - 404: Mueble no encontrado.
     */
    @DeleteMapping("{codigo}")
    public ResponseEntity<Void> eliminarMueble(@PathVariable Long codigo) {
        this.muebleService.eliminarMueble(codigo);
        return ResponseEntity.ok().build();
    }
}
