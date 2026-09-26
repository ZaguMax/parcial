package ar.edu.unahur.obj2.cafeteria.cliente;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.cafeteria.excepciones.ClienteSinPedidosException;
import ar.edu.unahur.obj2.cafeteria.pedido.Pedido;
import ar.edu.unahur.obj2.cafeteria.preferencias.Preferencia;

public class Cliente {
    private String nombre;
    private Boolean esEmpleado;
    private Preferencia preferencia;
    private List<Pedido> historialPedidos = new ArrayList<>();

    public Cliente(String nombre, boolean esEmpleado, Preferencia preferencia) {
        this.nombre = nombre;
        this.esEmpleado = esEmpleado;
        this.preferencia = preferencia;
    }

    public Preferencia getPreferencia() {
        return preferencia;
    }

    public void agregarPedido(Pedido pedido) {
        historialPedidos.add(pedido);
    }

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
