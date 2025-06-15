package Controlador;

import Modelo.*;
import Modelo.EstadosDePedido.Pedido;
import java.util.ArrayList;

public interface VistaDispositivo {
    
    public void mostrarMonto(float monto); //datos del servicio: monto
    
    public void mostrarPedidosHechos(ArrayList<Pedido> pedidos); //datos del servicio: pedidos
    
    public void mostrarCategorias(ArrayList<String> nombresDeCategorias);
    
    public void mostrarItems();
    
    public void mostrarError(String mensaje);
    
    public void loginCliente();
    
    public void terminarServicio();
    
}
