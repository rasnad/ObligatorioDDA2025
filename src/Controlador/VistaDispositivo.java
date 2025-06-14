package Controlador;

import Modelo.*;

public interface VistaDispositivo {
    
    public void mostrarMonto(float monto); //pedidos del servicio, monto
    
    public void mostrarCategorias(Menu menu);
    
    public void mostrarItems(Menu menu);
    
    public void mostrarError(String mensaje);
    
    public void loginCliente();
    
    public void terminarServicio();
    
}
