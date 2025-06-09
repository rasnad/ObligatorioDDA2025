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
    public void setGestor(Gestor gestor){

    }
    public void setEstado(EstadoPedido estado){

    }
    public void setComentario(){

    }
    public void confirmarPedido(){

    }
    public void restarStockDeItem(){
        item.restarStockDeInsumos();
    }
}
