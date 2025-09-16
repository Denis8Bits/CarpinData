package datacoins.CarpinData.dominio.exception;

public class MuebleYaExisteException extends RuntimeException {

    public MuebleYaExisteException(String color) {
        super("El mueble con color: " + color + " ya existe en el sistema.");
    }
}
