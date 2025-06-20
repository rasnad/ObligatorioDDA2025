package Modelo.EstadosDePedido;

import Modelo.Exception.PolloException;
import Modelo.Gestor;

public class PedidoNoConfirmado extends EstadoPedido{
    
    public PedidoNoConfirmado(Pedido pedido){
        this.setTipoDeEstado(TipoDeEstado.NO_CONFIRMADO);
        pedido.setEstado(this);
    }
    
    //Acciones válidas
    
    @Override
    public void confirmarPedido() throws PolloException {
        this.getPedido().setEstado( new PedidoConfirmado() );
        this.getPedido().hacerConfirmarPedido();
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
    public boolean cobrarPedido() throws PolloException {
        throw new PolloException("Tienes pedidos sin confirmar!");
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
