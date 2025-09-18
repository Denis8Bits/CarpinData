package datacoins.CarpinData.dominio.exception;

public class MaterialNoExisteException extends RuntimeException{
    public MaterialNoExisteException (Long codigoMaterial){
        super("el material con codigo: " + codigoMaterial + "no existe papi");
    }
}
