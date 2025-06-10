package obligatorio;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class SubsistemaServicio {
    ArrayList<Gestor> gestores;
    ArrayList<Pedido> pedidos;
    ArrayList<Item> items;
    ArrayList<Servicio> servicios;
    ArrayList<Menu> menues;
    ArrayList<UnidadProcesadora> unidadesProcesadoras;
    ArrayList<Insumo> insumos;

    public Pedido generarPedido(Item item, UnidadProcesadora unidadProcesadora, Servicio servicio, String comentario) throws PolloException {

        if (servicio.cliente == null) {
            throw new PolloException("Debe identificarse antes de realizar pedidos.");
        }

        if (item == null) {
            throw new PolloException("Debe seleccionar un ítem.");
        }

        Pedido pedido = new Pedido(item, unidadProcesadora, servicio, comentario);
        pedido.agregarObservador(servicio.dispositivo);
        servicio.pedidos.add(pedido);
        return pedido;
    }

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


}
