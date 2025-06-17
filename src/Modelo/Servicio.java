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
    float montoTotal; // OJO, ¿¿Se necesita??
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
    
    public String confirmarPedidos() throws PolloException {
        return confirmarPedidos(obtenerPedidosSinConfirmar());
    }

    public ArrayList<Pedido> obtenerPedidosSinConfirmar() {
        return pedidos.stream()
                .filter(pedido -> Objects.equals(pedido.getTipoDeEstado(), EstadoPedido.TipoDeEstado.NO_CONFIRMADO))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private String confirmarPedidos(ArrayList<Pedido> pedidosSinConfirmar) throws PolloException {
        ArrayList<Pedido> pedidosBorrados = new ArrayList<>();
        
        for (Pedido p : pedidosSinConfirmar){
            Item item = p.getItem();
            if ( ! item.tieneStock() ){
                pedidosBorrados.add(p);
                p.eliminarPedido();
            }
            p.confirmarPedido();
            p.restarStockDeItem();
        }
        
        if (!pedidosBorrados.isEmpty()){
            return reportarProblemasDeStock(pedidosBorrados);
        }
        
        return "";
    }
    
    private String reportarProblemasDeStock(ArrayList<Pedido> pedidosBorrados) throws PolloException{
        String borrados = "";
        for (Pedido p : pedidosBorrados){
            borrados += "Nos hemos quedado sin stock de " + p.getItem().getNombre() + " y no pudimos avisarte antes!! Lo siento mucho...\n";
        }
        return borrados;
    }

    public Cuenta calcularSubtotal(){
        
        float subtotal = 0;
        ArrayList<Item> itemsDescontados = new ArrayList<>();
        Cuenta cuenta = new Cuenta();
    
        //calcular descuento de cada pedido
        for (Pedido pedido : pedidos){
            float beneficioDelItem = cliente.calcularBeneficioItem( pedido.getItem() );
            if (beneficioDelItem != pedido.getItem().getPrecioUnitario()){
                itemsDescontados.add(pedido.getItem());
            }
            subtotal += beneficioDelItem;
        }
        cuenta.setItemsDescontados(itemsDescontados);
        //calcular descuentos sobre el total del servicio
        cuenta.setServicioConDescuento( cliente.calcularBeneficioServicio(subtotal) );
        cuenta.setServicioSinDescuento(subtotal);
        
        return cuenta;
    }

}
