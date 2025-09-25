package datacoins.CarpinData.dominio.exception;

public class ReservaNoExisteException extends RuntimeException {
    public ReservaNoExisteException(Long id) {
        super("La Reserva con ID: " + id + " no existe");
    }
}