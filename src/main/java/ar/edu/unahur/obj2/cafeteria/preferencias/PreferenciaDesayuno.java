package ar.edu.unahur.obj2.cafeteria.preferencias;

import ar.edu.unahur.obj2.cafeteria.categorias.Categoria;
import ar.edu.unahur.obj2.cafeteria.categorias.CategoriaDesayuno;

public class PreferenciaDesayuno extends Preferencia {
    
    private Categoria categoria = new CategoriaDesayuno();

    @Override
    protected Categoria obtenerCategoria() {
        return categoria;
    }
    
}
