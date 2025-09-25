package datacoins.CarpinData.dominio.exception;

public class CotizacionNoExisteException extends RuntimeException {

    public CotizacionNoExisteException(Long codigoCotizacion) {
        super("La cotización con código: " + codigoCotizacion + " no existe en el sistema.");
    }
}