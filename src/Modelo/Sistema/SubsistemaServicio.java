package Modelo.Sistema;

import Modelo.*;
import Modelo.Exception.PolloException;
import Modelo.EstadosDePedido.Pedido;
import Precarga.DatosDePrueba;
import java.util.ArrayList;

public class SubsistemaServicio {
    ArrayList<Gestor> gestores = new ArrayList<>();
    ArrayList<Pedido> pedidos = new ArrayList<>();
    ArrayList<Item> items = new ArrayList<>();
    ArrayList<Servicio> servicios = new ArrayList<>();
    ArrayList<Menu> menues = new ArrayList<>();
    ArrayList<UnidadProcesadora> unidadesProcesadoras = new ArrayList<>();
    ArrayList<Insumo> insumos = new ArrayList<>();
    DatosDePrueba datosDePrueba = new DatosDePrueba();

    protected SubsistemaServicio(){}
    
    protected void crearServicio(Dispositivo dispositivo, Cliente cliente){
        Servicio servicio = new Servicio(cliente, dispositivo);
        dispositivo.asignarCliente(cliente, servicio);
        cliente.asignarDispositivo(dispositivo, servicio);
        servicios.add(servicio);
    }
    
    protected Pedido generarPedido(Item item, Servicio servicio, String comentario) throws PolloException {

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
    
    protected Menu devolverMenuPorNombre(String nombreMenu) {
        return datosDePrueba.obtenerMenuPorNombre(nombreMenu);
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
