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
    ArrayList<Pedido> pedidos;
    ArrayList<Item> items;
    ArrayList<Servicio> servicios;
    ArrayList<Menu> menues;
    ArrayList<UnidadProcesadora> unidadesProcesadoras;
    ArrayList<Insumo> insumos;

    protected SubsistemaServicio(){}
    
    public Pedido generarPedido(Item item, Servicio servicio, String comentario) throws PolloException {

        if (servicio.getCliente() == null) {
            throw new PolloException("Debe identificarse antes de realizar pedidos.");
        }

        if (item == null) {
            throw new PolloException("Debe seleccionar un ítem.");
        }

        Pedido pedido = new Pedido(item, item.getUnidadProcesadora(), servicio, comentario);
        servicio.agregarPedido(pedido);
        return pedido;
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
