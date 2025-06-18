package Modelo.Sistema;

import Modelo.Cliente;
import Modelo.Dispositivo;
import Modelo.Exception.PolloException;
import Modelo.Gestor;
import Modelo.Item;
import Modelo.EstadosDePedido.*;
import Modelo.Menu;
import Modelo.Servicio;
import Modelo.UnidadProcesadora;
import Observador.Observable;

public class Fachada extends Observable {
    
    private final static Fachada instancia = new Fachada();
    private final SubsistemaAcceso subsistemaAcceso = new SubsistemaAcceso();
    private final SubsistemaServicio subsistemaServicio = new SubsistemaServicio();
    
    //Constructor Singleton
    private Fachada(){}
    
    //Retorno de Instancia
    public static Fachada getInstancia(){
        return instancia;
    }
    
    public static enum eventos{estadoDePedidoActualizado, nuevoMensaje};
    
    public void tomarPedido(Pedido pedido, Gestor gestor) throws PolloException {
        subsistemaServicio.tomarPedido(pedido, gestor);
    }

    public void loginCliente(Dispositivo dispositivo, String username, String password) throws PolloException {
        subsistemaAcceso.loginCliente(dispositivo, username, password );
    }

    public Gestor loginGestor(String username, String password) throws PolloException {
        return subsistemaAcceso.loginGestor(username, password);
    }
        
    public void logoutCliente(Dispositivo dispositivo, Cliente cliente) throws PolloException {
        subsistemaAcceso.logoutCliente(dispositivo, cliente);
    }
    
    public void logoutGestor(Gestor gestor){
        subsistemaAcceso.logoutGestor(gestor);
    }
    
    public void nuevoGestor(Gestor gestor){
        subsistemaAcceso.nuevoGestor(gestor);
    }
    
    public void nuevoCliente(Cliente cliente){
        subsistemaAcceso.nuevoCliente(cliente);
    }
    
    public void nuevoDispositivo(Dispositivo dispositivo){
        subsistemaAcceso.nuevoDispositivo(dispositivo);
    }

    public Pedido nuevoPedido(Item item, Servicio servicio, String comentario) throws PolloException {
        return subsistemaServicio.generarPedido(item, servicio, comentario);
    }
    
     public void eliminarPedido(Pedido pedido, Cliente cliente) throws PolloException {
        subsistemaServicio.eliminarPedido(pedido, cliente);
    }
    
    public void crearServicio(Dispositivo dispositivo, Cliente cliente){
        subsistemaServicio.crearServicio(dispositivo, cliente);
    }
    
    public Dispositivo devolverDispositivo(){
        return subsistemaAcceso.devolverDispositivo();
    }
    
    public Menu devolverMenuPorNombre(String nombre){
        return subsistemaServicio.devolverMenuPorNombre(nombre);
    }

    public void crearMenu(String nombre){
        subsistemaServicio.crearMenu(nombre);
    }
    
    public void agregarMenu(Menu menu){
        subsistemaServicio.agregarMenu(menu);
    }

    public void confirmarPedidos(Servicio servicio) throws PolloException { // Verifica los pedidos pednientes, los confirma y los devuelve
         subsistemaServicio.confirmarPedidos(servicio);
    }
    
    public void stockDeItemsSinConfirmar(Servicio servicio) throws PolloException {
        subsistemaServicio.stockDeItemsSinConfirmar(servicio);
    }
    
    public void calcularMontoTotal(Servicio servicio){
        subsistemaServicio.calcularMontoTotal(servicio);
    }
    
    public void nuevaUnidadProcesadora(UnidadProcesadora unidad){
        subsistemaServicio.nuevaUnidadProcesadora(unidad);
    }
    
    public UnidadProcesadora devolverUnidadProcesadoraPorNombre(String nombre){
        return subsistemaServicio.devolverUnidadProcesadoraPorNombre(nombre);
    }

    public void finalizarPedido(Pedido pedido, Gestor gestor) throws PolloException {
        subsistemaServicio.finalizarPedido(pedido, gestor);
    }

    public void entregarPedido(Pedido pedido, Gestor gestor) throws PolloException {
        subsistemaServicio.entregarPedido(pedido, gestor);
    }

}
