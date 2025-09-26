package datacoins.CarpinData.dominio.exception;

public class ClienteYaExisteException extends RuntimeException{
    public ClienteYaExisteException(String clienteNombre){
        super("el material de madera: "  + clienteNombre + "ya esta");
    }
}
