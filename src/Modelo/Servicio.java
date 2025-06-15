/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Modelo.EstadosDePedido.EstadoPedido;
import Modelo.EstadosDePedido.Pedido;
import Modelo.EstadosDePedido.PedidoNoConfirmado;
import Modelo.Exception.PolloException;
import Observador.Observable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

public class Servicio extends Observable {
    float montoTotal;
    ArrayList<Pedido> pedidos = new ArrayList<>();
    Cliente cliente;
    Dispositivo dispositivo;

    public Servicio(Cliente cliente, Dispositivo dispositivo) {
        this.cliente = cliente;
        this.dispositivo = dispositivo;
    }
    
    public ArrayList<Pedido> getPedidos() {
        return pedidos;
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
        confirmarPedidos(obetenerPedidosSinConfirmar());
    }

    public ArrayList<Pedido> obetenerPedidosSinConfirmar() {
        return pedidos.stream()
                .filter(pedido -> Objects.equals(pedido.getEstado(), "NO_CONFIRMADO"))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public void confirmarPedidos(ArrayList<Pedido> pedidosSinConfirmar) throws PolloException {
        for (Pedido p : pedidosSinConfirmar){
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
