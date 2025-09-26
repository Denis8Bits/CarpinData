package datacoins.CarpinData.dominio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Email;
import java.time.LocalDate;

public record ModClienteDto(

        Long codigo,

        @NotBlank(message = "El nombre es obligatorio")
        @Size(max = 150, message = "El nombre no debe exceder los 150 caracteres")
        String nombre,

        @NotBlank(message = "El apellido es obligatorio")
        @Size(max = 150, message = "El apellido no debe exceder los 150 caracteres")
        String apellido,

        @NotNull(message = "El teléfono es obligatorio")
        Integer telefono,

        @NotBlank(message = "El género es obligatorio")
        @Size(max = 50, message = "El genero no es valido")
        String genero,

        @NotNull(message = "La fecha de nacimiento es obligatoria")
        LocalDate fechaNacimiento,

        @NotBlank(message = "El correo es obligatorio")
        @Email(message = "El correo no tiene un formato válido")
        String correo,

        @NotBlank(message = "La contraseña es obligatoria")
        @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
        String contrasena
) {
}
