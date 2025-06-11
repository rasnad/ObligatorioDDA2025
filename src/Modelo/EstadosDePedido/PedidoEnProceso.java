package Modelo.EstadosDePedido;

import Modelo.Exception.PolloException;
import Modelo.Gestor;

public class PedidoEnProceso extends EstadoPedido{

    //Acciones válidas
    
    @Override
    public void finalizarPedido() throws PolloException {
        this.getPedido().setEstado( new PedidoFinalizado() );
    }
    
    @Override
    public void cobrarPedido() throws PolloException {
        this.getPedido().hacerCobrarPedido();
    }
    
    //Acciones inválidas

    @Override
    public void confirmarPedido() throws PolloException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminarPedido() throws PolloException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public void procesarPedido(Gestor gestor) throws PolloException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void entregarPedido() throws PolloException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
