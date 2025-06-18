package Controlador;

import Modelo.EstadosDePedido.Pedido;
import java.util.ArrayList;

public interface VistaProcesarPedidos {
    
    public void mostrarInfoGestor(String nombre, String unidadProcesadora);
    
    public void tomarPedido();
    
    public void finalizarPedido();
    
    public void entregarPedido();

    public void mostrarPedidosTomados(ArrayList<Pedido> pedidosTomados);
    
    public void mostrarPedidosConfirmados(ArrayList<Pedido> pedidosConfirmados);
    
    public void puedeCerrarse();

    public void mostrarError(String mensaje);
}
