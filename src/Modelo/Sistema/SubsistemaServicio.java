package Modelo.Sistema;

import Modelo.Exception.PolloException;
import Modelo.Gestor;
import Modelo.Insumo;
import Modelo.Item;
import Modelo.Menu;
import Modelo.EstadosDePedido.Pedido;
import Modelo.Servicio;
import Modelo.UnidadProcesadora;
import java.util.ArrayList;

public class SubsistemaServicio {
    ArrayList<Gestor> gestores;
    ArrayList<Pedido> pedidos = new ArrayList<>();
    ArrayList<Item> items;
    ArrayList<Servicio> servicios;
    ArrayList<Menu> menues;
    ArrayList<UnidadProcesadora> unidadesProcesadoras;
    ArrayList<Insumo> insumos;

    protected SubsistemaServicio(){}
    
    public void generarPedido(Servicio servicio) throws PolloException {

        if (servicio.getCliente() == null) {
            throw new PolloException("Debe identificarse antes de realizar pedidos.");
        }

        if (servicio.getItems().isEmpty()) {
            throw new PolloException("Debe seleccionar un ítem.");
        }

        pedidos.addAll(servicio.confirmarPedidos());
    }

    /* Implementar con State y Experto
    public ArrayList<Pedido> confirmarPedido(Servicio servicio) {
        return servicio.pedidos.stream() // Recorremos la lista de pedidos del servicio,
                .filter(pedido -> pedido.getEstadoPedido() == EstadoPedido.PEDIDO_NO_CONFIRMADO)  // y nos quedamos con lo aun no confirmado
                .peek(pedido -> pedido.confirmarPedido()) // y lo confirmamos.
                .collect(Collectors.toCollection(ArrayList::new)); // Nos quedamos con dicha lista.
    }

    public ArrayList<Pedido> cancelarPedido(Servicio servicio) {
        return servicio.pedidos.stream() // Recorremos la lista de pedidos del servicio,
                .filter(pedido -> pedido.getEstadoPedido() == EstadoPedido.PEDIDO_NO_CONFIRMADO)  // y nos quedamos con lo aun no confirmado
                .peek(pedido -> pedido.eliminar())// y lo confirmamos.
                .collect(Collectors.toCollection(ArrayList::new)); // Nos quedamos con dicha lista.
    }
    */
}
