/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Modelo.EstadosDePedido.Pedido;
import Modelo.Exception.PolloException;
import java.util.ArrayList;
import java.util.HashMap;

public class Servicio {
    float montoTotal;
    ArrayList<Pedido> pedidos = new ArrayList<>();
    HashMap<Item, String> items = new HashMap<>();
    Cliente cliente;
    Dispositivo dispositivo;

    public Servicio(Cliente cliente, Dispositivo servicio) {
        this.cliente = cliente;
        this.dispositivo = servicio;
        this.items = new HashMap<>();
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

    public HashMap<Item, String> agregarItemsAlServicio(Item item) {
        items.put(item, "");
        return items;
    }

    public void agregarComentarioAlItem(Item item, String comentario){ // Aplicar Logica en la iu por cada item posibilidad de agregar comentario
        items.put(item, comentario);
    }

    public HashMap<Item, String> getItems() {
        return items;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public ArrayList<Pedido> confirmarPedidos() throws PolloException {
        ArrayList<Pedido> copia = new ArrayList(pedidos);
        // recorrer items con un entry set
        for (HashMap.Entry<Item, String> entry : items.entrySet()) {
            Item item = entry.getKey();
            Pedido pedido = new Pedido(item, item.getUnidadProcesadora(), this);
            pedido.confirmarPedido();
            copia.add(pedido);
            agregarPedido(pedido);
        }
        this.pedidos = copia;
        return this.pedidos;
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
