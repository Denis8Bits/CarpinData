package datacoins.CarpinData.dominio.exception;

public class TipoNoExisteException extends RuntimeException {
    public TipoNoExisteException(Long idTipo) {
        super("El tipo con ID: " + idTipo + " no existe en el sistema.");
    }
}