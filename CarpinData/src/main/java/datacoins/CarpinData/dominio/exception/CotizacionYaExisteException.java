package datacoins.CarpinData.dominio.exception;

public class CotizacionYaExisteException extends RuntimeException {

    public CotizacionYaExisteException(Integer cantidad) {
        super("La cotización con cantidad: " + cantidad + " ya existe en el sistema.");
    }
}