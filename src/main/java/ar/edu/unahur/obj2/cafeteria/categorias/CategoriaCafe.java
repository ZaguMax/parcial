package ar.edu.unahur.obj2.cafeteria.categorias;

import ar.edu.unahur.obj2.cafeteria.productos.Producto;

public class CategoriaCafe implements Categoria {

    @Override
    public double calcularPrecio(Producto producto) {
        return producto.getPrecioBase();
    }
}
