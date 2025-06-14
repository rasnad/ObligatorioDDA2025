package Controlador;

import Modelo.*;
import Modelo.EstadosDePedido.Pedido;
import java.util.ArrayList;

public interface VistaDispositivo {
    
    public void mostrarMonto(float monto); //datos del servicio: monto
    
    public void mostrarPedidosHechos(ArrayList<Pedido> pedidos); //datos del servicio: pedidos
    
    public void mostrarCategorias(Menu menu);
    
    public void mostrarItems(Menu menu);
    
    public void mostrarError(String mensaje);
    
    public void loginCliente();
    
    public void terminarServicio();
    
}
