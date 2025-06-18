package Controlador;

import Modelo.*;
import Modelo.EstadosDePedido.*;
import Observador.Observador;
import Modelo.Sistema.Fachada;
import Modelo.Exception.PolloException;
import java.util.ArrayList;

public class ControladorDispositivo implements Observador {
    
    private final VistaDispositivo vista;
    private final Dispositivo dispositivo;
    private final Fachada fachada = Fachada.getInstancia();
    private Servicio servicio;
    private Cliente cliente;
    private Menu menu;
    
    public ControladorDispositivo(VistaDispositivo vista){
        this.vista = vista;
        this.menu = fachada.devolverMenuPorNombre("Menu1");
        dispositivo = fachada.devolverDispositivo(); //tomar un dispositivo random de la fachada
        fachada.agregarObservador(this);
        inicializarVista();
    }
    
    public Servicio getServicio() {
        return servicio;
    }
    
    public Cliente getCliente() {
        return cliente;
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
    
    public String devolverUnidadProcesadoraDelPedido(Pedido p){
        return p.getTipoDeEstado().equals(EstadoPedido.TipoDeEstado.NO_CONFIRMADO) ? "" : p.getItem().getUnidadProcesadora().getNombre();
    }
    
    public String devolverGestorDelPedido(Pedido p){
        return p.getTipoDeEstado().equals(EstadoPedido.TipoDeEstado.NO_CONFIRMADO) ? "" : (p.getGestor() != null) ? p.getGestor().getNombreCompleto() : "ESPERANDO GESTOR";
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
    
    public Cuenta getCuenta(){
        if (servicio != null){
            return servicio.getCuenta();
        }
        return null;
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
    
    public void chequearStockDeItemsSinConfirmar(){
        try{
            fachada.stockDeItemsSinConfirmar(servicio);
        } catch (PolloException e){
            vista.mostrarError("Oops!!! Perdón! Sowwy", e.getMessage());
        }
    }
    
    public ArrayList<String> itemsDeCortesia(){
        ArrayList<String> itemsCortesia = new ArrayList<>();
        for (Item item : servicio.getCuenta().getItemsDescontados()) {
            itemsCortesia.add(item.getNombre() + " de regalo! valor: $" + item.getPrecioUnitario() );
        }
        return itemsCortesia;
    }
    
    public float montoAhorradoEnItemsDeCortesia(){
        float total = 0;
        for ( Item i : servicio.getCuenta().getItemsDescontados() ){
            total += i.getPrecioUnitario();
        }
        return total;
    }
    
    public void terminarServicioEnDispositivo(){
        boolean sePudoCobrar = false;
        
        try {
            sePudoCobrar = fachada.logoutCliente(dispositivo, servicio, cliente); //Errores de auth, pedidosSinProcesar y de cobro
        } catch (PolloException p) {
            vista.mostrarError("Error de cobro",p.getMessage());
            return; // CASO 1: Errores de auth y "Tienes pedidos sin confirmar!", no puede hacer logout
        }
        
        if (servicio.getPedidos().isEmpty()){
            limpiarControlador();
            return; // CASO 2: Login exitoso, no tiene pedidos, puede hacer logout
        }
        
        int pedidosNoEntregados = servicio.contarPedidosNoEntregados(); //CASO 3: Warning al usuario por pedidos no entregados
        System.out.println("PEDIDOS NO ENTREGADOS " + pedidosNoEntregados);
        if (pedidosNoEntregados > 0){
            vista.mostrarError("OJO!! NO TE OLVIDES DEL MORFI!!", "¡Tienes " + pedidosNoEntregados +  " en proceso, recuerda ir a retirarlos!");
        }
            
        crearFactura(); //CASO 4: Cobro de pedidos: si se pagó, puede desloguearse, sino no + error en pantalla
        
        if (!sePudoCobrar){
            vista.mostrarPagoComplicado();
        } else {
            vista.mostrarPagoExitoso();
            limpiarControlador();
        }
        
    }
    
    private void limpiarControlador(){
        this.servicio = null;
        this.cliente = null;
        vista.limpiar();
    }
    
    public void crearFactura(){
        Cuenta cuenta = getCuenta();
        String itemsDeCortesia = "";
        String descuentosEnServicio = "";
        String averigueBeneficios = "";
        
        if (cuenta != null){
            
            String tipoCliente = getCliente().getTipo().toString();
            ArrayList<String> itemsCortesia = itemsDeCortesia();
            
            if ( !itemsCortesia.isEmpty() ) {
                itemsCortesia.addFirst("Items de cortesía:");
                itemsCortesia.addLast("Total ahorrado en items de cortesía: $" + montoAhorradoEnItemsDeCortesia() );
            }
            
            boolean huboDescuentosAlServicio = cuenta.descuentosHechosAlServicio() > 0;

            if ( huboDescuentosAlServicio ){
                descuentosEnServicio = "Descuentos sobre el servicio: " + cuenta.descuentosHechosAlServicio();
            }
            
            if ("Cliente Común".equals(tipoCliente)){
                averigueBeneficios = "<br><br>Oh no! Ud. no es elegible para ninguno de nuestros beneficios!<br>Si es cliente regular, puede averiguar sobre nuestros beneficios tomándose el 192 Manga y caminando hasta la casa de nuestro barman en Villa García.<br>";            } else if ( ! itemsDeCortesia.isEmpty() || huboDescuentosAlServicio ) {
                tipoCliente = "Descuentos por ser: " + tipoCliente;
            } else {
                tipoCliente = "Gracias por ser " + tipoCliente + "!";
            }
        
            vista.mostrarFactura(itemsCortesia, descuentosEnServicio, averigueBeneficios, tipoCliente, getCuenta());
            
        }
    }
    
    public void avisarPedidosListos() {
        for( Pedido pedido : servicio.getPedidos() ){
            if( !pedido.getEstaFinalizado() && pedido.getTipoDeEstado().equals(EstadoPedido.TipoDeEstado.FINALIZADO ) ){
                String mensaje = "PEDIDO LISTO! VENGA A BUSCAR " + pedido.getItem().getNombre() + " a " + pedido.getItem().getUnidadProcesadora().getNombre();
                pedido.marcarEstaFinalizado();
                vista.mostrarMensajeDelSistema(mensaje);
            }
        }
    }

    //Evento del modelo
    @Override
    public void actualizar(Object evento, Object origen) {
        if (evento.equals(Fachada.eventos.estadoDePedidoActualizado) ){
            if (servicio != null){
                chequearStockDeItemsSinConfirmar();
                vista.mostrarPedidosHechos(servicio.getPedidos());
                servicio.calcularCuenta();
                vista.mostrarMonto( servicio.getCuenta().getServicioConDescuento() ); //usar subtotal con descuentos aplicados de clase Cuenta
                vista.obtenerCategoriaSeleccionadaYActualizarItems();
                avisarPedidosListos(); //evento nuevoMensaje
            }
        }
    }
}
