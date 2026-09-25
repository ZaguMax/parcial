package ar.edu.unahur.obj2.cafeteria.cliente;

import java.util.List;

import ar.edu.unahur.obj2.cafeteria.excepciones.ClienteSinPedidosException;
import ar.edu.unahur.obj2.cafeteria.pedido.Pedido;

public class Cliente {
    private String nombre;
    private Boolean esEmpleado;
    private List<Pedido> historialPedidos;

    public Boolean getEsEmpleado() {
        return esEmpleado;
    }

    public double costoTotal() {

        double total = 0;

        for (Pedido pedido : this.getHistorialPedidos()) {
            total = total + pedido.getImporteTotal();
        }
        return total;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Pedido> getHistorialPedidos() {
        if (historialPedidos.isEmpty()) {
            throw new ClienteSinPedidosException("El cliente no posee pedidos");
        }
        return historialPedidos;
    }


}
