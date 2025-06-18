package Modelo;

import Modelo.EstadosDePedido.*;
import Modelo.Exception.PolloException;
import java.util.ArrayList;

public class Gestor extends Usuario {
    private UnidadProcesadora unidadProcesadora;
    private ArrayList<Pedido> pedidosTomados = new ArrayList<>();
    private String userName;
    private String trabajo;

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

    public void finalizarPedido(Pedido pedido) throws PolloException {
        pedido.finalizarPedido();
    }
    
    public boolean tienePedidosNoEntregados(){
        for (Pedido p : pedidosTomados){
            if (!p.getTipoDeEstado().equals(EstadoPedido.TipoDeEstado.ENTREGADO)){
                return false;
            }
        }
        return true;
    }
}
