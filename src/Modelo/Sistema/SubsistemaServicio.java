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

    protected SubsistemaServicio() {
    }


    protected void crearServicio(Dispositivo dispositivo, Cliente cliente) {
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

        Fachada.getInstancia().notificarObservadores(Fachada.eventos.estadoDePedidoActualizado);

        return pedido;
    }

    protected void eliminarPedido(Pedido pedido) {
        if (pedido == null) {
            //acá un throw, ver si la letra no tiene un CA específico
        }
        
        try {
            pedido.eliminarPedido(); //se pone en null en el servicio, pone su servicio en null y se saca de la unidadprocesadora
            pedidos.remove(pedido);
            Fachada.getInstancia().notificarObservadores(Fachada.eventos.estadoDePedidoActualizado);
        } catch (PolloException e) {
            
            
            System.out.println("que loco che, no se pudo eliminar el pedido");
            System.out.println("cambiar este mensaje en eliminarpedido subsistemaservicio");
            
        }
    }

    protected Menu devolverMenuPorNombre(String nombreMenu) {
        for (Menu m : menues) {
            if (m.getNombre().equals(nombreMenu)) {
                return m;
            }
        }
        return null;
    }

    protected void crearMenu(String nombre) {
        menues.add(new Menu(nombre));
    }

    public void confirmarPedidos(Servicio servicio) throws PolloException {

        if (servicio == null || servicio.getCliente() == null) {
            throw new PolloException("Debe identificarse antes de confirmar el servicio");
        }

        if (servicio.obtenerPedidosSinConfirmar().isEmpty()) {
            throw new PolloException("No hay pedidos nuevos.");
        }

        String errores = servicio.confirmarPedidos(); //este método ya se encarga de limpiar los problemas de stock
        
        Fachada.getInstancia().notificarObservadores(Fachada.eventos.estadoDePedidoActualizado);
        
        if (!errores.isEmpty()){
            throw new PolloException(errores);
        }
    }

    public void tomarPedido(Pedido pedido, Gestor gestor) throws PolloException {

        if(pedido == null) {
            throw new PolloException("Para tomar un pedido debes seleccionar uno.");
        }

        pedido.procesarPedido(gestor);
        Fachada.getInstancia().notificarObservadores(Fachada.eventos.estadoDePedidoActualizado);

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
