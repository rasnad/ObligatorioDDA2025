package Modelo.EstadosDePedido;

import Modelo.Exception.PolloException;
import Modelo.Gestor;

public class PedidoEntregado extends EstadoPedido{

    public PedidoEntregado(){
        this.setTipoDeEstado(TipoDeEstado.ENTREGADO);
    }
    
    //Acciones válidas
    
    @Override
    public boolean cobrarPedido() throws PolloException {
        return this.getPedido().hacerCobrarPedido();
    }
    
    //Acciones inválidas
    
    @Override
    public void procesarPedido(Gestor gestor) throws PolloException {
        throw new PolloException("No se puede procesar un pedido ya Entregado.");
    }

    @Override
    public void confirmarPedido() throws PolloException {
        throw new PolloException("No se puede confirmar un pedido ya Entregado.");
    }

    @Override
    public void eliminarPedido() throws PolloException {
        throw new PolloException("No se puede eliminar un pedido ya Entregado.");
    }


    @Override
    public void finalizarPedido() throws PolloException {
        this.getPedido().setEstado(new PedidoEntregado());
        this.getPedido().getGestor().getPedidosTomados().remove(this.getPedido());
    }

    @Override
    public void entregarPedido() throws PolloException {
        throw new PolloException("No se puede entregar un pedido ya Entregado.");
    }
    
}
