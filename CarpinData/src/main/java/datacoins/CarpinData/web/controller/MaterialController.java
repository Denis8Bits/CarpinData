package datacoins.CarpinData.web.controller;

import datacoins.CarpinData.dominio.dto.MaterialDto;
import datacoins.CarpinData.dominio.dto.ModMaterialDto;
import datacoins.CarpinData.dominio.service.MaterialService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/materiales")
public class MaterialController {

    private final MaterialService materialService;

    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }

    //listar
    @GetMapping
    public ResponseEntity<List<MaterialDto>> obtenerTodo() {
        return ResponseEntity.ok(this.materialService.obtenerTodo());
    }

    //buscar por codigo
    @GetMapping("{codigo}")
    public ResponseEntity<MaterialDto> obtenerMaterialPorId(@PathVariable Long codigo) {
        return ResponseEntity.ok(this.materialService.obtenerMaterialPorCodigo(codigo));
    }

    //guardarMaterial
    @PostMapping
    public ResponseEntity<MaterialDto> guardarMaterial(@RequestBody @Valid MaterialDto materialDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.materialService.guardarMaterial(materialDto));
    }

    //modificarMaterial
    @PutMapping("{codigo}")
    public ResponseEntity<MaterialDto> modificarMaterial(
            @PathVariable Long codigo,
            @RequestBody @Valid ModMaterialDto modMaterialDto) {
        return ResponseEntity.ok(this.materialService.modificarMaterial(codigo, modMaterialDto));
    }

    //eliminarMaterial
    @DeleteMapping("{codigo}")
    public ResponseEntity<Void> eliminarMaterial(@PathVariable Long codigo) {
        this.materialService.eliminarMaterial(codigo);
        return ResponseEntity.ok().build();
    }
}
