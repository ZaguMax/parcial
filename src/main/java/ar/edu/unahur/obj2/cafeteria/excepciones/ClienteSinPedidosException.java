package ar.edu.unahur.obj2.cafeteria.excepciones;

/**
 * ClienteSinPedidosException
 */
public class ClienteSinPedidosException extends RuntimeException {

    public ClienteSinPedidosException() {
        super("Cliente sin pedidos");
    }

    public ClienteSinPedidosException(String message) {
        super(message);
    }

}
