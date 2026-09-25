package ar.edu.unahur.obj2.cafeteria.pedido;

import ar.edu.unahur.obj2.cafeteria.categorias.Categoria;
import ar.edu.unahur.obj2.cafeteria.cliente.Cliente;
import ar.edu.unahur.obj2.cafeteria.configuracion.ConfiguracionCafeteria;
import ar.edu.unahur.obj2.cafeteria.excepciones.CantidadInvalidaException;
import ar.edu.unahur.obj2.cafeteria.productos.Producto;


public class Pedido {

    private Cliente cliente;
    private Producto producto;
    private Integer cantidad;
    private Double importeTotal;

    
    public Pedido(Cliente cliente, Producto producto, Integer cantidad, Categoria categoria) {
        if (cantidad <= 0) {
            throw new CantidadInvalidaException("La cantidad debe ser mayor a cero");
        }
        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;
        this.importeTotal = calcularImporte(categoria);

        producto.reducirStock(cantidad);
    }

    private Double calcularImporte(Categoria categoria){
        Double precioUnitario = categoria.calcularPrecio(producto);
        Double subtotal = precioUnitario * cantidad;

        ConfiguracionCafeteria config = ConfiguracionCafeteria.getInstancia();
        Double conServicio = subtotal * (1 + config.getPorcentajeCargoServicio()/100);
        Double total = conServicio * (1 + config.getPorcentajeImpuestos()/100);
        return total;    
    }

    public Integer getCantidad(){
        return cantidad;
    }

    public Double getImporteTotal() {
        return importeTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Producto getProducto() {
        return producto;
    }
}
