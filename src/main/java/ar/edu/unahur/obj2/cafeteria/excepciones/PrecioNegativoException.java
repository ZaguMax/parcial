package ar.edu.unahur.obj2.cafeteria.excepciones;


public class PrecioNegativoException extends RuntimeException {

    public PrecioNegativoException() {
        super("El precio ingresado no debe ser negativo");
    }

    public PrecioNegativoException(String message) {
        super(message);
    }
    
}
