package Modelo.EstadosDePedido;

import Modelo.Exception.PolloException;
import Modelo.Gestor;

public class PedidoFinalizado extends EstadoPedido{
    
    //Acciones válidas
    
    @Override
    public void cobrarPedido() throws PolloException {
         this.getPedido().hacerCobrarPedido();
    }
    
    @Override
    public void entregarPedido() throws PolloException {
         this.getPedido().setEstado(new PedidoEntregado());
    }
    
    //Acciones inválidas
    
    @Override
    public void procesarPedido(Gestor gestor) throws PolloException {
        throw new PolloException("No puede procesarse un pedido ya Finalizado.");
    }

    @Override
    public void confirmarPedido() throws PolloException {
        throw new PolloException("No puede confirmarse un pedido ya Finalizado.");
    }

    @Override
    public void eliminarPedido() throws PolloException {
        throw new PolloException("No puede eliminarse un pedido ya Finalizado.");
    }

    

    @Override
    public void finalizarPedido() throws PolloException {
        throw new PolloException("No puede finalizarse un pedido ya Finalizado.");
    }

    
}
