package ar.edu.unahur.obj2.cafeteria.preferencias;
import ar.edu.unahur.obj2.cafeteria.categorias.Categoria;
import ar.edu.unahur.obj2.cafeteria.categorias.CategoriaCafe;

public class PreferenciaCafe extends Preferencia {

    private Categoria categoria = new CategoriaCafe();

    @Override
    protected Categoria obtenerCategoria() {
        return categoria;
    }
    
}
