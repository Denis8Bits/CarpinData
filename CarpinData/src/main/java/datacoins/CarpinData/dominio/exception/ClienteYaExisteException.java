package datacoins.CarpinData.dominio.exception;

public class ClienteYaExisteException extends RuntimeException{
    public ClienteYaExisteException (String clienteNombre){
        super("el cliente" + clienteNombre + "ya existe");
    }
}
