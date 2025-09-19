package datacoins.CarpinData.web.controller;

import datacoins.CarpinData.dominio.dto.ModTipoDto;
import datacoins.CarpinData.dominio.dto.TipoDto;
import datacoins.CarpinData.dominio.service.TipoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/tipos")
public class TipoController {

    private final TipoService tipoService;

    public TipoController(TipoService tipoService) {
        this.tipoService = tipoService;
    }

    // Obtiene todos los tipos
    @GetMapping
    public ResponseEntity<List<TipoDto>> obtenerTodo() {
        return ResponseEntity.ok(this.tipoService.obtenerTodo());
    }

    // Obtiene un tipo por su ID
    @GetMapping("{id}")
    public ResponseEntity<TipoDto> obtenerTipoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(this.tipoService.obtenerTipoPorId(id));
    }

    // Crea un nuevo tipo
    @PostMapping
    public ResponseEntity<TipoDto> guardarTipo(@Valid @RequestBody TipoDto tipoDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.tipoService.guardarTipo(tipoDto));
    }

    // Modifica un tipo existente
    @PutMapping("{id}")
    public ResponseEntity<TipoDto> modificarTipo(
            @PathVariable Long id,
            @Valid @RequestBody ModTipoDto modTipoDto) {
        return ResponseEntity.ok(this.tipoService.modificarTipo(id, modTipoDto));
    }

    // Elimina un tipo por su ID
    @DeleteMapping("{id}")
    public ResponseEntity<Void> eliminarTipo(@PathVariable Long id) {
        this.tipoService.eliminarTipo(id);
        return ResponseEntity.ok().build();
    }
}