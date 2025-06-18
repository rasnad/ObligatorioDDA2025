package Modelo.Sistema;

import Modelo.*;
import Modelo.Exception.PolloException;
import Modelo.EstadosDePedido.*;
import java.util.ArrayList;

public class SubsistemaServicio {
    private ArrayList<Servicio> servicios = new ArrayList<>();
    private ArrayList<Menu> menues = new ArrayList<>();
    private ArrayList<UnidadProcesadora> unidadesProcesadoras = new ArrayList<>();

    protected SubsistemaServicio() {}


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
            throw new PolloException("Debe seleccionar un pedido.");
        }
        
        pedido.eliminarPedido(); //se pone en null en el servicio, pone su servicio en null y se saca de la unidadprocesadora
        Fachada.getInstancia().notificarObservadores(Fachada.eventos.estadoDePedidoActualizado);
    }

    protected void nuevaUnidadProcesadora(UnidadProcesadora unidad){
        unidadesProcesadoras.add(unidad);
    }
    
    protected UnidadProcesadora devolverUnidadProcesadoraPorNombre(String nombre){
        for (UnidadProcesadora u : unidadesProcesadoras) {
            if (u.getNombre().equals(nombre)) {
                return u;
            }
        }
        return null;
    }

    protected void crearMenu(String nombre) {
        menues.add(new Menu(nombre));
    }
    
    protected void agregarMenu(Menu menu){
        menues.add(menu);
    }
    
    protected Menu devolverMenuPorNombre(String nombreMenu) {
        for (Menu m : menues) {
            if (m.getNombre().equals(nombreMenu)) {
                return m;
            }
        }
        return null;
    }

    protected void confirmarPedidos(Servicio servicio) throws PolloException {

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

    protected void tomarPedido(Pedido pedido, Gestor gestor) throws PolloException {

        if(pedido == null) {
            throw new PolloException("Para tomar un pedido debes seleccionar uno.");
        }

        pedido.procesarPedido(gestor);
        Fachada.getInstancia().notificarObservadores(Fachada.eventos.estadoDePedidoActualizado);

    }

    protected void finalizarPedido(Pedido pedido, Gestor gestor) throws PolloException {

        if(gestor.getPedidosTomados().isEmpty()) {
            throw new PolloException("El gestor no tiene pedidos aun asignados.");
        }

        if(pedido == null) {
            throw new PolloException("Debe seleccionar un pedido.");
        }

        gestor.finalizarPedido(pedido);
        Fachada.getInstancia().notificarObservadores(Fachada.eventos.nuevoMensaje);
    }

    protected void entregarPedido(Pedido pedido, Gestor gestor) throws PolloException {

        if(gestor.getPedidosTomados().isEmpty()) {
            throw new PolloException("El gestor no tiene pedidos aun asignados.");
        }

        if(pedido == null) {
            throw new PolloException("Debe seleccionar un pedido.");
        }

        gestor.pedidoEntregado(pedido);
        Fachada.getInstancia().notificarObservadores(Fachada.eventos.estadoDePedidoActualizado);
    }
    
    protected void calcularMontoTotal(Servicio servicio){
        if (servicio != null && !servicio.getPedidos().isEmpty()){
            servicio.calcularCuenta(); //setea la cuenta en el servicio
        }
    }
    
    protected void stockDeItemsSinConfirmar(Servicio servicio) throws PolloException {
        ArrayList<Pedido> eliminados = new ArrayList<>();
        ArrayList<Pedido> copiaDelServicio = new ArrayList<>(servicio.getPedidos());
        
        for (Pedido p : copiaDelServicio ){
            if (p.getTipoDeEstado() == EstadoPedido.TipoDeEstado.NO_CONFIRMADO){
                if ( !p.getItem().tieneStock() ){
                    eliminados.add(p);
                    p.eliminarPedido();
                }
            }
        }
        
        if ( !eliminados.isEmpty()){
            String error = "";
            for (Pedido p : eliminados){
                error += "Lo sentimos, nos hemos quedado sin stock de " + p.getItem().getNombre() + ", por lo que hemos quitado el pedido del servicio.\n";
            }
            if ( eliminados.size() > 3){ //Manejo de dEcepciones
                error += "Perdón. Disculpe!! Noo, por favor no se vaya!! Noooooooooo!";
            }
            
            throw new PolloException(error);
        }
    }
    
}
