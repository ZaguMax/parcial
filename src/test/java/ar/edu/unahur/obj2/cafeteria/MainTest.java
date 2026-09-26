package ar.edu.unahur.obj2.cafeteria;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ar.edu.unahur.obj2.cafeteria.cliente.Cliente;
import ar.edu.unahur.obj2.cafeteria.configuracion.ConfiguracionCafeteria;
import ar.edu.unahur.obj2.cafeteria.excepciones.CantidadInvalidaException;
import ar.edu.unahur.obj2.cafeteria.excepciones.ClienteInvalidoException;
import ar.edu.unahur.obj2.cafeteria.excepciones.ClienteSinPedidosException;
import ar.edu.unahur.obj2.cafeteria.excepciones.PrecioNegativoException;
import ar.edu.unahur.obj2.cafeteria.pedido.Pedido;
import ar.edu.unahur.obj2.cafeteria.preferencias.Preferencia;
import ar.edu.unahur.obj2.cafeteria.preferencias.PreferenciaCafe;
import ar.edu.unahur.obj2.cafeteria.preferencias.PreferenciaDesayuno;
import ar.edu.unahur.obj2.cafeteria.preferencias.PreferenciaEmpleado;
import ar.edu.unahur.obj2.cafeteria.preferencias.PreferenciaEspecial;
import ar.edu.unahur.obj2.cafeteria.productos.Producto;

public class MainTest {

    @BeforeEach
    void resetearConfiguracion() {
        ConfiguracionCafeteria.getInstancia().setPorcentajeCargoServicio(0);
        ConfiguracionCafeteria.getInstancia().setPorcentajeImpuestos(0);
    }

    @Test
    void unClienteEmpleadoSiPuedeHacerUnPedidoConPreferenciaEmpleado() {
        // Arrange
        Producto producto = new Producto("Medialuna", 100.0, 10);
        Preferencia preferenciaEmpleado = new PreferenciaEmpleado();
        Cliente cliente = new Cliente("Claudio", true, preferenciaEmpleado);

        // Act
        Pedido pedido = new Pedido(cliente, producto, 1);

        // Assert
        assertEquals(0.0, pedido.getImporteTotal());
    }

    @Test
    void unClienteNoEmpleadoNoPuedeHacerUnPedidoConPreferenciaEmpleado() {
        // Arrange
        Producto producto = new Producto("Cafe", 100.0, 10);
        Preferencia preferenciaEmpleado = new PreferenciaEmpleado();
        Cliente cliente = new Cliente("Rodrigo", false, preferenciaEmpleado);

        // Assert
        assertThrows(ClienteInvalidoException.class, () -> new Pedido(cliente, producto, 1));
    }

    @Test
    void elHistorialAcumulaLosPedidosRealizados() {
        // Arrange
        Preferencia preferencia = new PreferenciaCafe();
        Cliente cliente = new Cliente("Florencia", false, preferencia);
        Producto producto = new Producto("Cafe", 100.0, 10);

        // Act
        Pedido primerPedido = new Pedido(cliente, producto, 1);
        Pedido segundoPedido = new Pedido(cliente, producto, 2);
        List<Pedido> historial = cliente.getHistorialPedidos();

        // Assert
        assertEquals(2, historial.size());
        assertTrue(historial.contains(primerPedido));
        assertTrue(historial.contains(segundoPedido));
    }

    @Test
    void unClienteSinPedidosLanzaExcepcionAlPedirHistorial() {

        // Arrange
        Preferencia preferencia = new PreferenciaCafe();
        Cliente cliente = new Cliente("Camila", false, preferencia);

        // Assert
        assertThrows(ClienteSinPedidosException.class, cliente::getHistorialPedidos);
    }

    @Test
    void unPedidoConPreferenciaCafeNoAplicaRecargo() {
        // Arrange
        Producto producto = new Producto("Cafe", 100.0, 10);
        Preferencia preferencia = new PreferenciaCafe();
        Cliente cliente = new Cliente("Juan", false, preferencia);

        // Act
        Pedido pedido = new Pedido(cliente, producto, 2);

        // Assert
        assertEquals(200.0, pedido.getImporteTotal());
    }

    @Test
    void unPedidoConPreferenciaDesayunoAplica50PorCientoDeRecargo() {
        // Arrange
        Producto producto = new Producto("Cafe", 100.0, 10);
        Preferencia preferencia = new PreferenciaDesayuno();
        Cliente cliente = new Cliente("Ruben", false, preferencia);

        // Act
        Pedido pedido = new Pedido(cliente, producto, 2);

        // Assert
        assertEquals(300.0, pedido.getImporteTotal());
    }

    @Test
    void unPedidoConPreferenciaEspecialAplica70PorCientoDeRecargo() {
        // Arrange
        Producto producto = new Producto("Medialuna", 100.0, 10);
        Preferencia preferencia = new PreferenciaEspecial();
        Cliente cliente = new Cliente("IlloJuan", false, preferencia);

        // Act
        Pedido pedido = new Pedido(cliente, producto, 2);

        // Assert
        assertEquals(340.0, pedido.getImporteTotal());
    }

    @Test
    void unPedidoConPreferenciaEmpleadoTienePrecioCero() {
        // Arrange
        Producto producto = new Producto("Cafe", 100.0, 10);
        Preferencia preferencia = new PreferenciaEmpleado();
        Cliente cliente = new Cliente("Anastasia", true, preferencia);

        // Act
        Pedido pedido = new Pedido(cliente, producto, 2);

        // Assert
        assertEquals(0.0, pedido.getImporteTotal());
    }

    @Test
    void unProductoConPrecioBaseNegativoLanzaExcepcion() {
        // Assert
        assertThrows(PrecioNegativoException.class, () -> new Producto("Hamborguesa", -500.0, 180));
    }

    @Test
    void unPedidoConCantidadNegativaLanzaExcepcion() {
        // Arrange
        Producto producto = new Producto("SevenUp", 1000.0, 10);
        Cliente cliente = new Cliente("DiegoDeLaVega", false, new PreferenciaCafe());

        // Assert
        assertThrows(CantidadInvalidaException.class, () -> new Pedido(cliente, producto, -3));
    }

    @Test
    void elCostoTotalSumaTodosLosImportesDelHistorial() {
        // Arrange
        Producto producto = new Producto("Cortado", 100.0, 10);
        Cliente cliente = new Cliente("Klark", false, new PreferenciaCafe());

        // Act
        new Pedido(cliente, producto, 1);
        new Pedido(cliente, producto, 2);

        // Assert
        assertEquals(300.0, cliente.costoTotal(), 0.001);
    }

    @Test
    void elPedidoRegistraElClienteYElProductoCorrectos() {
        // Arrange
        Producto producto = new Producto("CocaCola", 100.0, 10);
        Cliente cliente = new Cliente("PeterParker", false, new PreferenciaCafe());

        // Act
        Pedido pedido = new Pedido(cliente, producto, 1);

        // Assert
        assertEquals(cliente, pedido.getCliente());
        assertEquals(producto, pedido.getProducto());
    }

    @Test
    void elCalculoConsideraServicioEImpuestosSobreElSubtotal() {
        // Arrange
        Producto producto = new Producto("Cafecito", 100.0, 10);
        Cliente cliente = new Cliente("Moni", false, new PreferenciaCafe());
        ConfiguracionCafeteria.getInstancia().setPorcentajeCargoServicio(10);
        ConfiguracionCafeteria.getInstancia().setPorcentajeImpuestos(21);    

        // Act
        Pedido pedido = new Pedido(cliente, producto, 1);

        // Assert
        assertEquals(133.1, pedido.getImporteTotal(), 0.001);
    }
    
    @Test
    void alCrearUnPedidoSeDescuentaElStockDelProducto() {
        // Arrange
        Producto producto = new Producto("Medialuna", 50.0, 20);
        Cliente cliente = new Cliente("Otto", false, new PreferenciaCafe());

        // Act
        new Pedido(cliente, producto, 5);

        // Assert
        assertEquals(15, producto.getCantidadDisponible());
    }

    @Test
    void elHistorialDeCadaClienteEsIndependiente() {
        // Arrange
        Producto producto = new Producto("Cafe", 100.0, 10);
        Cliente cliente1 = new Cliente("Juan", false, new PreferenciaCafe());
        Cliente cliente2 = new Cliente("Ana", false, new PreferenciaCafe());

        // Act
        new Pedido(cliente1, producto, 1);
        new Pedido(cliente1, producto, 2);
        new Pedido(cliente2, producto, 3);

        // Assert
        assertEquals(2, cliente1.getHistorialPedidos().size());
        assertEquals(1, cliente2.getHistorialPedidos().size());
    }

    @Test
    void sePuedeVerLaCantidadDeElementosDelPedido(){
        // Arrange
        Producto producto = new Producto("Cafe", 100.0, 10);
        Cliente cliente = new Cliente("Chayane", false, new PreferenciaCafe());
        Pedido pedido = new Pedido(cliente, producto, 7);
        
        // Assert
        assertEquals(7, pedido.getCantidad());
    }
}

