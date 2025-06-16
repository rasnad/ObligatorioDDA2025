/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controlador;

import Modelo.EstadosDePedido.Pedido;
import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public interface VistaProcesarPedidos {
    
    public void mostrarInfoGestor(String nombre, String unidadProcesadora);
    
    public void mostrarPedidosConfirmados(ArrayList<Pedido> pedidosConfirmados);
    
    public void tomarPedido();
    
    public void FinalizarPedido();
    
    public void EntregarPedido();
    
}
