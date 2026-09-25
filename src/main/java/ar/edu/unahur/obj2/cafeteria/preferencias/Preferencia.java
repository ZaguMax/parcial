package ar.edu.unahur.obj2.cafeteria.preferencias;

import ar.edu.unahur.obj2.cafeteria.categorias.Categoria;
import ar.edu.unahur.obj2.cafeteria.cliente.Cliente;

public abstract class Preferencia {
    
    public final Categoria resolverParaPedido(Cliente cliente){
        validar(cliente);
        return obtenerCategoria();
    }

    protected void validar(Cliente cliente){}
    
    protected abstract Categoria obtenerCategoria();
}
