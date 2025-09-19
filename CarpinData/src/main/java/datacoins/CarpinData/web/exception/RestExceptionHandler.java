package datacoins.CarpinData.web.exception;

import datacoins.CarpinData.dominio.exception.Error;
import datacoins.CarpinData.dominio.exception.MuebleNoExisteException;
import datacoins.CarpinData.dominio.exception.MuebleYaExisteException;
import datacoins.CarpinData.dominio.exception.TipoNoExisteException;
import datacoins.CarpinData.dominio.exception.TipoYaExisteException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class RestExceptionHandler {

    // Manejo de excepciones de Mueble
    @ExceptionHandler(MuebleYaExisteException.class)
    public ResponseEntity<Error> handleException(MuebleYaExisteException ex) {
        Error error = new Error("mueble-ya-existe", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(MuebleNoExisteException.class)
    public ResponseEntity<Error> handleException(MuebleNoExisteException ex) {
        Error error = new Error("mueble-no-existe", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    // Manejo de excepciones de Tipo
    @ExceptionHandler(TipoYaExisteException.class)
    public ResponseEntity<Error> handleException(TipoYaExisteException ex) {
        Error error = new Error("tipo-ya-existe", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(TipoNoExisteException.class)
    public ResponseEntity<Error> handleException(TipoNoExisteException ex) {
        Error error = new Error("tipo-no-existe", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    // Manejo de errores de validación
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<Error>> handleException(MethodArgumentNotValidException ex) {
        List<Error> errores = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(fieldError -> {
            errores.add(new Error(fieldError.getField(), fieldError.getDefaultMessage()));
        });
        return ResponseEntity.badRequest().body(errores);
    }

    // Manejo de errores genéricos
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleException(Exception ex) {
        Error error = new Error("error-desconocido", ex.getMessage());
        return ResponseEntity.internalServerError().body(error);
    }
}