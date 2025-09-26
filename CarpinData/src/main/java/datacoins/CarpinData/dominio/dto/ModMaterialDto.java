package datacoins.CarpinData.dominio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.time.LocalDate;

public record ModMaterialDto(
<<<<<<< HEAD

=======
>>>>>>> 8488f3c51107f5ec64640cf86146263d130f2204
        Long id,

        @NotBlank(message = "El nombre del material es obligatorio")
        @Size(max = 150, message = "El nombre no debe exceder los 150 caracteres")
        String nombre,

        @NotBlank(message = "La descripción es obligatoria")
        @Size(max = 500, message = "La descripción no debe exceder los 500 caracteres")
        String descripcion,

        @NotNull(message = "El costo es obligatorio")
        @PositiveOrZero(message = "El costo debe ser un valor positivo o cero")
        BigDecimal costo,

        @NotNull(message = "El stock es obligatorio")
        @PositiveOrZero(message = "El stock debe ser un valor positivo o cero")
        Integer stock,

        @NotNull(message = "La fecha de ingreso es obligatoria")
        LocalDate fechaIngreso,

        @NotBlank(message = "El estado es obligatorio")
        @Size(max = 50, message = "El estado no debe exceder los 50 caracteres")
        String estado
) {
}
