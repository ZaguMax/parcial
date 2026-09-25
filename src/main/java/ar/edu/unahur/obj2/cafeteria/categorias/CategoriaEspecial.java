package ar.edu.unahur.obj2.cafeteria.categorias;

import ar.edu.unahur.obj2.cafeteria.productos.Producto;

public class CategoriaEspecial implements Categoria {

    @Override
    public double calcularPrecio(Producto producto) {
        return producto.getPrecioBase() * 1.7;
    }
    
}
