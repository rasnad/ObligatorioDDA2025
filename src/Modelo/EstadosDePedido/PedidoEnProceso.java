package Modelo.EstadosDePedido;

import Modelo.Exception.PolloException;
import Modelo.Gestor;

public class PedidoEnProceso extends EstadoPedido{

    public PedidoEnProceso(){
        this.setTipoDeEstado(TipoDeEstado.EN_PROCESO);
    }
    
    //Acciones válidas
    
    @Override
    public void finalizarPedido() throws PolloException {
        this.getPedido().setEstado(new PedidoFinalizado());
    }
    
    @Override
    public boolean cobrarPedido() throws PolloException {
        return this.getPedido().hacerCobrarPedido();
    }
    
    //Acciones inválidas

    @Override
    public void confirmarPedido() throws PolloException {
        throw new PolloException("No se puede confirmar un pedido que ya se encuentra En Proceso.");
    }

    @Override
    public void eliminarPedido() throws PolloException {
        throw new PolloException("Un poco tarde... ¡¡¡YA ESTAMOS ELABORANDO ESTE PEDIDO!!!.");
    }
    
    @Override
    public void procesarPedido(Gestor gestor) throws PolloException {
        throw new PolloException("No se puede procesar un pedido que ya se encuentra En Proceso.");
    }

    @Override
    public void entregarPedido() throws PolloException {
        throw new PolloException("Debe finalizar el pedido.");
        // Podría agregarse al throw para aclarle al gestor: "Claaro muchacho, la gente no come cosas crudas!"
    }
    
}
