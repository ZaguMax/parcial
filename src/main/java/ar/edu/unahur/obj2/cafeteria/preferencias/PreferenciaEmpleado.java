package ar.edu.unahur.obj2.cafeteria.preferencias;

import ar.edu.unahur.obj2.cafeteria.categorias.Categoria;
import ar.edu.unahur.obj2.cafeteria.categorias.CategoriaEmpleado;
import ar.edu.unahur.obj2.cafeteria.cliente.Cliente;
import ar.edu.unahur.obj2.cafeteria.excepciones.ClienteInvalidoException;

public class PreferenciaEmpleado extends Preferencia {
    
    private Categoria categoria = new CategoriaEmpleado();

    @Override
    protected Categoria obtenerCategoria() {
        return categoria;
    }

    @Override
    protected void validar(Cliente cliente){
        if(!cliente.getEsEmpleado()){
            throw new ClienteInvalidoException("El cliente debe ser empleado para realizar este pedido");
        }
    }
}
