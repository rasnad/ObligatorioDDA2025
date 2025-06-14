package Controlador;

import Modelo.*;

public interface VistaDispositivo {
    
    public void mostrarServicio(Servicio servicio);
    
    public void mostrarMenu(Menu menu);
    
    public void mostrarError(String mensaje);
    
    public void loginCliente();
    
    //métodos para mostrar información cargada por el controlador
}
