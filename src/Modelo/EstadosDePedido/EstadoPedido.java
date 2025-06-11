package Modelo.EstadosDePedido;

import Modelo.Exception.PolloException;
import Modelo.Gestor;

public abstract class EstadoPedido {
    
    private Pedido pedido;
    
    public Pedido getPedido(){
        return pedido;
    }
    
    public abstract void procesarPedido(Gestor gestor) throws PolloException;
    
    public abstract void confirmarPedido() throws PolloException;
    
    public abstract void eliminarPedido() throws PolloException;;
    
    public abstract void cobrarPedido() throws PolloException;;
    
    public abstract void finalizarPedido() throws PolloException;;
    
    public abstract void entregarPedido() throws PolloException;;
}
