/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Modelo.EstadosDePedido.Pedido;
import Modelo.Exception.PolloException;
import java.util.ArrayList;

public class Servicio {
    float montoTotal;
    ArrayList<Pedido> pedidos = new ArrayList<>();
    Cliente cliente;
    Dispositivo dispositivo;

    public Servicio(Cliente cliente, Dispositivo servicio) {
        this.cliente = cliente;
        this.dispositivo = servicio;
    }
    
    public Cliente getCliente(){
        return cliente;
    }
    
    public Dispositivo getDispositivo(){
        return dispositivo;
    }
    
    public void agregarPedido(Pedido pedido){
        pedidos.add(pedido);
    }
    
    public void removerPedido(Pedido pedido){
        pedidos.remove(pedido);
    }
    
    public void confirmarPedidos() throws PolloException {
        ArrayList<Pedido> copia = new ArrayList(pedidos);
        for (Pedido p : pedidos){
            p.confirmarPedido();
        }
    }

    public float calcularSubtotal(){
        float subtotal = 0;
        //calcular descuento de cada pedido
        for (Pedido pedido : pedidos){
            subtotal += cliente.calcularBeneficioItem( pedido.getItem() );
        }
        //calcular descuentos sobre el total del servicio
        return cliente.calcularBeneficioServicio(subtotal);
    }

}
