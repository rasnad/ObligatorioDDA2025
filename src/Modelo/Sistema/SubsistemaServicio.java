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
        
        if (servicio == null || servicio.getCliente() == null) {
            throw new PolloException("Debe identificarse antes de realizar pedidos.");
        }

        if (item == null) {
            throw new PolloException("Debe seleccionar un ítem.");
        }

        Pedido pedido = new Pedido(item, servicio, comentario);
        servicio.agregarPedido(pedido);
        
        Fachada.getInstancia().notificarObservadores(Fachada.eventos.pedidoAgregado);
        
        return pedido;
    }
    
    protected void eliminarPedido(Pedido pedido){
        if (pedido == null){
            //acá un throw, ver si la letra no tiene un CA específico
        }
        
        pedido.getServicio().removerPedido(pedido);
        pedidos.remove(pedido);
        Fachada.getInstancia().notificarObservadores(Fachada.eventos.pedidoEliminado);
        //si ya se envió al la unidad procesadora ? ? ? eliminarlo de ahí o no ?? ver letra
    }
    
    protected Menu devolverMenuPorNombre(String nombreMenu) {
        for (Menu m : menues){
            if (m.getNombre().equals(nombreMenu)){
                return m;
            }
        }
        return null;
    }

    protected void crearMenu(String nombre){
        menues.add (new Menu(nombre));
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
