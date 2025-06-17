package Modelo.Sistema;

import Modelo.*;
import Modelo.Exception.PolloException;
import Modelo.EstadosDePedido.Pedido;
import Precarga.DatosDePrueba;
import java.util.ArrayList;

public class SubsistemaServicio {
    ArrayList<Gestor> gestores = new ArrayList<>();
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

    protected void eliminarPedido(Pedido pedido, Cliente cliente) throws PolloException {
        
        if (cliente == null) {
            throw new PolloException("Debe identificarse antes de eliminar un pedido.");
        }
        
        if (pedido == null) {
            throw new PolloException(cliente.getNombreCompleto() + "Debe seleccionar un pedido.");
        }
        
        pedido.eliminarPedido(); //se pone en null en el servicio, pone su servicio en null y se saca de la unidadprocesadora
        Fachada.getInstancia().notificarObservadores(Fachada.eventos.estadoDePedidoActualizado);
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
    
}
