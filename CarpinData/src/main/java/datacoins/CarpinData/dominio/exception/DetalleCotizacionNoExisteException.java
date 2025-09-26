package datacoins.CarpinData.dominio.exception;

public class DetalleCotizacionNoExisteException extends RuntimeException {
    public DetalleCotizacionNoExisteException(Long id) {
        super("El DetalleCotizacion con código: " + id + " no existe en El sistema.");
    }
}
