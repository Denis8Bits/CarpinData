package datacoins.CarpinData.dominio.exception;

public class MuebleNoExisteException extends RuntimeException {

    public MuebleNoExisteException(Long codigoMueble) {
        super("El mueble con código: " + codigoMueble + " no existe en el sistema.");
    }
}
