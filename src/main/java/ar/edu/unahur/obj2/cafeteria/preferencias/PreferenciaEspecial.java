package ar.edu.unahur.obj2.cafeteria.preferencias;

import ar.edu.unahur.obj2.cafeteria.categorias.Categoria;
import ar.edu.unahur.obj2.cafeteria.categorias.CategoriaEspecial;

public class PreferenciaEspecial extends Preferencia {
    
    private Categoria categoria = new CategoriaEspecial();

    @Override
    protected Categoria obtenerCategoria() {
        return categoria;
    }
}
