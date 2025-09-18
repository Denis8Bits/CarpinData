package datacoins.CarpinData.web.mapper;

import datacoins.CarpinData.dominio.Estado;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Component
public class EstadoMapper {

    /**
     * Convierte una cadena a un valor del enum {@link Estado}.
     * Ejemplo: "ACTIVE" → Estado.active
     */
    @Named("generarEstado")
    public static Estado generar(String estado) {
        if (estado == null) return null;
        return switch (estado.toUpperCase()) {
            case "ACTIVE" -> Estado.active;
            case "INACTIVE" -> Estado.inactive;
            default -> null;
        };
    }

    /**
     * Convierte un enum {@link Estado} a una cadena en mayúsculas.
     * Ejemplo: Estado.active → "ACTIVE"
     */
    @Named("generarEstadoString")
    public static String generarEstadoString(Estado estado) {
        if (estado == null) return null;
        return switch (estado) {
            case active -> "ACTIVE";
            case inactive -> "INACTIVE";
        };
    }
}
