/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package obligatorio;

import java.util.Date;

/**
 *
 * @author lucas
 */
public class Pedido {
    Item item;
    EstadoPedido estadoPedido;
    UnidadProcesadora unidadProcesadora;
    Gestor gestor;
    Servicio servicio;
    String comentario;
    Date fechaYHora;

    public Pedido(Item item, UnidadProcesadora unidadProcesadora, Servicio servicio, String comentario) {
        this.item = item;
        this.unidadProcesadora = unidadProcesadora;
        this.servicio = servicio;
        this.comentario = comentario;
        
        //estadoPedido = Estado de pedido nuevo acá, ver patrón state
        fechaYHora = new Date(); //revisar bien lo del formateador simple de fechas
    }
    
    public Item getItem(){
        return item;
    }
    
    public void setGestor(Gestor gestor){

    }
    
    public void setEstado(EstadoPedido estado){

    }
    
    public void confirmarPedido(){

    }
    
    public void restarStockDeItem(){
        item.restarStockDeInsumos();
    }
}
