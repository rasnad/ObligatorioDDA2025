package Controlador;

import Modelo.*;

public interface VistaDispositivo {
    
    public void mostrarServicio(Servicio servicio); //pedidos del servicio, monto
    
    public void mostrarMenu(Menu menu); //categorías e items
    
    public void mostrarError(String mensaje);
    
    public void loginCliente();
    
}
