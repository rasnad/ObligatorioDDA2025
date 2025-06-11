package Modelo;

import Modelo.EstadosDePedido.Pedido;
import java.util.ArrayList;

public class Gestor extends Usuario {
    UnidadProcesadora unidadProcesadora;
    ArrayList<Pedido> pedidosTomados = new ArrayList<>();
    String userName;
    String trabajo;

    public Gestor(String nombreCompleto, String username, String password, UnidadProcesadora unidad){
        super(nombreCompleto, username, password);
        this.unidadProcesadora = unidad;
    }
 
    public UnidadProcesadora getUnidadProcesadora(){
        return unidadProcesadora;
    }
    
    public void tomarPedido(Pedido pedido){
        pedidosTomados.add(pedido);
    }
    
    public void pedidoListo(Pedido pedido){}
    public void pedidoEntregado(Pedido pedido){}

}
