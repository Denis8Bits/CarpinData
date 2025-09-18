package datacoins.CarpinData.dominio.exception;

public class ClienteNoExisteException extends RuntimeException{
    public ClienteNoExisteException (Long codigoCliente){
        super("el cliente con codigo: " + codigoCliente + "no existe");
    }
}
