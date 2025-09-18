package datacoins.CarpinData.dominio.exception;

public class MaterialYaExisteException extends RuntimeException{
    public MaterialYaExisteException(String materialNombre){
        super("el material de madera: "  + materialNombre + "ya anda");
    }
}
