package datacoins.CarpinData.dominio.exception;

public class CategoriaNoExisteException extends RuntimeException {
    public CategoriaNoExisteException(Long codigo) {
        super("La Categoria con codigo:" + codigo + "no existe papi");
    }
}
