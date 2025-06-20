package Controlador;

import Modelo.*;
import Modelo.EstadosDePedido.Pedido;
import java.util.ArrayList;

public interface VistaDispositivo {
    
    public void cambiarTitulo(String titulo);
            
    public void mostrarMonto(float monto); //datos del servicio: monto
    
    public void mostrarPedidosHechos(ArrayList<Pedido> pedidos); //datos del servicio: pedidos
    
    public void mostrarMensajeDelSistema(String mensaje);
    
    public void mostrarCategorias(ArrayList<CategoriaItem> categorias);
    
    public void mostrarItems(CategoriaItem categoria);
    
    public void mostrarFactura(ArrayList<String> itemsDeCortesia, String descuentosEnServicio, String averigueBeneficios, String tipoCliente, Cuenta cuenta);
    
    public void mostrarError(String titulo, String mensaje);
    
    public void mostrarPagoExitoso();

    public void mostrarPagoComplicado();
    
    public void loginCliente();
    
    public void terminarServicio();
    
    public void limpiar();

    public void obtenerCategoriaSeleccionadaYActualizarItems();
    
}
