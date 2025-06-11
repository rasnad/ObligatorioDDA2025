package Modelo.Sistema;

import Modelo.Cliente;
import Modelo.Dispositivo;
import Modelo.Exception.PolloException;
import Modelo.Gestor;
import Modelo.Item;
import Modelo.EstadosDePedido.Pedido;
import Modelo.Servicio;
import Modelo.UnidadProcesadora;
import Observador.Observable;
import java.util.ArrayList;

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

    public void loginCliente(Dispositivo dispositivo, String username, String password) throws PolloException {
        subsistemaAcceso.loginCliente(dispositivo, username, password );
    }

    public void loginGestor(String username, String password) throws PolloException {
        subsistemaAcceso.loginGestor(username, password);
    }
        
    public void logoutCliente(Dispositivo dispositivo, Cliente cliente){
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

    public Pedido nuevoPedido(Item item, UnidadProcesadora unidadProcesadora, Servicio servicio, String comentario) throws PolloException {
        return subsistemaServicio.generarPedido(item, servicio, comentario);
    }

    /*
    public ArrayList<Pedido> confirmarPedidos(Servicio servicio){ // Verifica los pedidos pednientes, los confirma y los devuelve
        return subsistemaServicio.confirmarPedido(servicio);
    }

    public ArrayList<Pedido> cancelarPedidos(Servicio servicio){ // Verifica los pedidos pednientes, los cancela y los devuelve
        return subsistemaServicio.cancelarPedido(servicio);
    }
    */


}
