package Modelo;

import Modelo.EstadosDePedido.Pedido;
import Modelo.Exception.PolloException;
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
    
    public void tomarPedido(Pedido pedido) {
        pedidosTomados.add(pedido);
    }
    
    public void pedidoListo(Pedido pedido) throws PolloException {
        pedido.finalizarPedido();
    }
    
    public void pedidoEntregado(Pedido pedido) throws PolloException {
        pedido.entregarPedido();
    }

    public ArrayList<Pedido> getPedidosTomados() {
        return pedidosTomados;
    }
}
