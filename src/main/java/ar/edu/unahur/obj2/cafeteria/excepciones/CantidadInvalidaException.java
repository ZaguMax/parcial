package ar.edu.unahur.obj2.cafeteria.excepciones;

public class CantidadInvalidaException extends RuntimeException {

    public CantidadInvalidaException() {
        super("Cantidad Invalida");
    }

    public CantidadInvalidaException(String message) {
        super(message);
    }

}
