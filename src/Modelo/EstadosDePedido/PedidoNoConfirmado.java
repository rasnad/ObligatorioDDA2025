package Modelo.EstadosDePedido;

import Modelo.Exception.PolloException;
import Modelo.Gestor;

public class PedidoNoConfirmado extends EstadoPedido{
    
    public PedidoNoConfirmado(){
        this.setTipoDeEstado(TipoDeEstado.NO_CONFIRMADO);
    }
    
    //Acciones válidas
    
    @Override
    public void confirmarPedido() throws PolloException {
        this.getPedido().setEstado( new PedidoConfirmado() );
    }

    @Override
    public void eliminarPedido() throws PolloException {
        this.getPedido().hacerEliminarPedido();
    }

    
    //Acciones inválidas

    @Override
    public void procesarPedido(Gestor gestor) throws PolloException {
        throw new PolloException("No se puede procesar un pedido no confirmado. Debe primero confirmarse.");
    }

    @Override
    public void cobrarPedido() throws PolloException {
        throw new PolloException("No se puede cobrar un pedido no confirmado. Debe primero confirmarse o procesarse.");
    }

    @Override
    public void finalizarPedido() throws PolloException {
        throw new PolloException("No puede finalizarse un pedido no confirmado. Debe primero confirmarse o procesarse.");
    }

    @Override
    public void entregarPedido() throws PolloException {
        throw new PolloException("No puede entregarse un pedido no confirmado. Debe primero confirmarse y luego procesarse.");
    }
    
}
