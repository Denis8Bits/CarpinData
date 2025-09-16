package datacoins.CarpinData.dominio.exception;

public class TipoYaExisteException extends RuntimeException {
    public TipoYaExisteException(String nombre) {
        super("El tipo con nombre: " + nombre + " ya existe en el sistema.");
    }
}