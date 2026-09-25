package ar.edu.unahur.obj2.cafeteria.excepciones;

/**
 * ClienteInvalidoException
 */
public class ClienteInvalidoException extends RuntimeException {

    public ClienteInvalidoException() {
        super("El cliente es Invalido");
    }

    public ClienteInvalidoException(String message) {
        super(message);
    }

}
