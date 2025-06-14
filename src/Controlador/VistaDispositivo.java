package Controlador;

import Modelo.*;
import java.util.ArrayList;

public interface VistaDispositivo {
    
    public void mostrarMonto(float monto); //pedidos del servicio, monto
    
    public void mostrarCategorias(ArrayList<String> nombresDeCategorias);
    
    public void mostrarItems(CategoriaItem categoria);
    
    public void mostrarError(String mensaje);
    
    public void loginCliente();
    
    public void terminarServicio();
    
}
