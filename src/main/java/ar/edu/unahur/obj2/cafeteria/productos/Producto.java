package ar.edu.unahur.obj2.cafeteria.productos;

import ar.edu.unahur.obj2.cafeteria.excepciones.PrecioNegativoException;

public class Producto {
    private String nombre;
    private Double precioBase;
    private Integer cantidadDisponible;

    public Producto(String nombre, Double precioBase, Integer cantidadDisponible) {
        this.nombre = nombre;
        this.precioBase = validarPrecioBase(precioBase);
        this.cantidadDisponible = cantidadDisponible;
    }

    private Double validarPrecioBase(Double precioBase){
        if (precioBase < 0){
            throw new PrecioNegativoException("El precio base de un producto no puede ser negativo");
        }
        return precioBase;
    }

    public void reducirStock(Integer cantidad){
        cantidadDisponible = cantidadDisponible - cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getPrecioBase() {
        return precioBase;
    }

    public Integer getCantidadDisponible() {
        return cantidadDisponible;
    }
}
