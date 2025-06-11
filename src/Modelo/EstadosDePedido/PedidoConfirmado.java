package Modelo.EstadosDePedido;

import Modelo.Exception.PolloException;
import Modelo.Gestor;

public class PedidoConfirmado extends EstadoPedido{

    public PedidoConfirmado(){
        this.setTipoDeEstado(TipoDeEstado.CONFIRMADO);
    }
    
    //Acciones válidas
    
    @Override
    public void eliminarPedido() {
        this.getPedido().hacerEliminarPedido();
    }

    @Override
    public void cobrarPedido() {
        //this.getPedido().hacerCobrarPedido();
    }
    
    @Override //Gestor toma pedido
    public void procesarPedido(Gestor gestor) {
        this.getPedido().hacerProcesarPedido(gestor);
        this.getPedido().setEstado( new PedidoEnProceso() );
    }

    //Acciones inválidas
    
    @Override
    public void confirmarPedido() throws PolloException {
        throw new PolloException("El pedido ya se encuentra confirmado");
    }

    @Override
    public void finalizarPedido() throws PolloException {
        throw new PolloException("No se puede finalizar un pedido Confirmado. Debe ser Procesado primero.");
    }

    @Override
    public void entregarPedido() throws PolloException {
        throw new PolloException("No se puede entregar un pedido Confirmado. Debe ser Procesado y Finalizado primero.");
    }
    
}
