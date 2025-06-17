package Controlador;

import Modelo.*;
import Modelo.EstadosDePedido.*;
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
    
    public String getEstadoFormateado(Pedido p){
        if (EstadoPedido.TipoDeEstado.NO_CONFIRMADO.equals(p.getTipoDeEstado())){
            return "SIN CONFIRMAR";
        }
        return p.getEstadoTexto();
    }
    
    public String devolverComentarioPlaceholder() {
        return "Desea modificar algo sobre la preparación? Deje su comentario acá...";
    }
    
    //Eventos del usuario
    
    private void inicializarVista(){
        //Carga de información dinámica que necesita la vista
        vista.mostrarMonto(0);
        vista.mostrarCategorias( menu.getCategorias() );
        vista.mostrarMensajeDelSistema("Esperando mensajes del sistema...");
    }
    
    public void loginCliente(String username, String password) {
        try {
            dispositivo.puedeLoguearseCliente();
            fachada.loginCliente(dispositivo, username, password);
            servicio = dispositivo.getServicio();
            cliente = dispositivo.getCliente();
            vista.cambiarTitulo( "Le damos la bienvenida " + cliente.getNombreCompleto() + "!" );
        } catch (PolloException e){
            vista.mostrarError("Error de login", e.getMessage());
        }
    }
    
    //Este Salir / QuitarObservador NO se usa porque esta ventana no debería poder cerrarse, por tanto, el controller siempre observa
    public void salir(){
        servicio.quitarObservador(this);
    }
    
    public void terminarServicioEnDispositivo(){
        if (servicio != null){
            fachada.logoutCliente(dispositivo, cliente);
            servicio.getCliente().terminarServicioEnDispositivo();
            dispositivo.liberarClienteDelServicio();
            this.servicio = null;
            this.cliente = null;
            vista.limpiar();
        }
    }
    
    public void agregarPedido(Item item, String comentario) {
        try {
            fachada.nuevoPedido(item, this.servicio, comentario);
        } catch (PolloException e){
            vista.mostrarError("Error al agregar pedido", e.getMessage());
        }
    }
    
    public void eliminarPedido(Pedido pedido) {
        try {
            fachada.eliminarPedido(pedido, cliente);
        } catch (PolloException e){
            vista.mostrarError("Error al eliminar pedido", e.getMessage());
        }
    }

    public void confirmarPedidos() {
        try {
            fachada.confirmarPedidos(servicio);
        } catch (PolloException e){
            vista.mostrarError("Error al confirmar pedido", e.getMessage());
        }
    }
    
    public void chequearItemsSinConfirmar(){
        try{
            fachada.stockDeItemsSinConfirmar(servicio);
        } catch (PolloException e){
            vista.mostrarError("Oops!!! Perdón! Sowwy", e.getMessage());
        }
    }
    
    //Evento del modelo
    @Override
    public void actualizar(Object evento, Object origen) {
        if (evento.equals(Fachada.eventos.estadoDePedidoActualizado) ){
            if (servicio != null){
                chequearItemsSinConfirmar();
                vista.mostrarPedidosHechos(servicio.getPedidos());
                vista.mostrarMonto( servicio.calcularSubtotal());
                vista.obtenerCategoriaSeleccionadaYActualizarItems();
                //vista.mostrarMensaje(); //evento nuevoMensaje
            }
        }
    }
}
