package Controlador;

import Modelo.*;
<<<<<<< HEAD
=======
import Modelo.EstadosDePedido.Pedido;
>>>>>>> e8ce253b76d64b7b4d2f2b86a246cc40cf3a734f
import java.util.ArrayList;

public interface VistaDispositivo {
    
    public void mostrarMonto(float monto); //datos del servicio: monto
    
    public void mostrarPedidosHechos(ArrayList<Pedido> pedidos); //datos del servicio: pedidos
    
    public void mostrarCategorias(ArrayList<String> nombresDeCategorias);
    
    public void mostrarItems(CategoriaItem categoria);
    
    public void mostrarError(String mensaje);
    
    public void loginCliente();
    
    public void terminarServicio();
    
}
