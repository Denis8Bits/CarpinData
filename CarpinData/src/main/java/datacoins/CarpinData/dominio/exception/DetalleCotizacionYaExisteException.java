package datacoins.CarpinData.dominio.exception;

public class DetalleCotizacionYaExisteException extends RuntimeException {

    public DetalleCotizacionYaExisteException(Long idCotizacion) {
        super("La cotizacion con codigo: " + idCotizacion + " ya existe en este Detalle Cotizacion.");
    }
}
