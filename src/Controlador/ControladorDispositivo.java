package Controlador;

import Modelo.*;
import Modelo.EstadosDePedido.Pedido;
import Observador.Observador;
import Modelo.Sistema.Fachada;
import Modelo.Exception.PolloException;
import java.util.ArrayList;

public class ControladorDispositivo implements Observador {
    
    private VistaDispositivo vista;
    private Servicio servicio;

    private Dispositivo dispositivo;
    private Cliente cliente;
    private Fachada fachada = Fachada.getInstancia();
    private Menu menu;
    
    public ControladorDispositivo(VistaDispositivo vista){
        this.vista = vista;
        this.menu = fachada.devolverMenuPorNombre("Menu de Invierno");
        dispositivo = fachada.devolverDispositivo(); //tomar un dispositivo random de la fachada
        fachada.agregarObservador(this);
        inicializarVista();
    }
    
    public Servicio getServicio() {
        return servicio;
    }
    
    public String getDispositivoId(){
        return dispositivo.getId() + "";
    }
    
    public ArrayList<Item> getItemsPorCategoria(CategoriaItem categoria){
        return categoria.getItems();
    }
    
    //Eventos del usuario
    
    private void inicializarVista(){
        //Carga de información dinámica que necesita la vista
        vista.mostrarMonto(0.00F);
        vista.mostrarCategorias( menu.getCategorias() );
        vista.mostrarMensajeDelSistema("Esperando mensajes del sistema...");
    }
    
    public void loginCliente(String username, String password) {
        try {
            dispositivo.puedeLoguearseCliente();
            fachada.loginCliente(dispositivo, username, password);
            servicio = dispositivo.getServicio();
            cliente = dispositivo.getCliente();
        } catch (PolloException e){
            vista.mostrarError(e.getMessage());
        }
    }
    
    public void salir(){
        servicio.quitarObservador(this);
    }
    
    public void terminarServicioEnDispositivo(){
        if (servicio != null){
            fachada.logoutCliente(dispositivo, cliente);
            servicio.quitarObservador(this);
            servicio.getCliente().terminarServicioEnDispositivo();
            dispositivo.liberarClienteDelServicio();
            servicio = null;
        }
    }
    
    public void agregarPedido(Item item, String comentario) {
        try {
            fachada.nuevoPedido(item, this.servicio, comentario);
            System.out.println("Pedido agregado");
        } catch (PolloException e){
            vista.mostrarError(e.getMessage());
        }
    }
    
    public void eliminarPedido(Pedido pedido) throws PolloException {
        try {
            fachada.eliminarPedido(pedido);
        } catch (PolloException e){
            vista.mostrarError(e.getMessage());
        }
    }
    
    //Evento del modelo
    @Override
    public void actualizar(Object evento, Object origen) {
        
        if (evento.equals(Fachada.eventos.pedidoAgregado) || evento.equals(Fachada.eventos.pedidoEliminado)){
            if (servicio != null){
                vista.mostrarPedidosHechos(servicio.getPedidos());
            }
        } else if (evento.equals(Fachada.eventos.pedidoEliminado)){
            if (servicio != null){
                vista.mostrarPedidosHechos(servicio.getPedidos());
            }
        }
        //Algún evento:
        //vista.mostrarPedidosHechos(); //evento estadoDePedidoActualizado
        //vista.mostrarMonto(); //evento montoActualizado
        //vista.mostrarMensaje(); //evento nuevoMensaje
    }

}
