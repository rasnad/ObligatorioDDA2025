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
public class Pedido extends ObservableBase implements Observador {
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
        this.estadoPedido = EstadoPedido.PEDIDO_NO_CONFIRMADO;
        //estadoPedido = Estado de pedido nuevo acá, ver patrón state
        fechaYHora = new Date(); //revisar bien lo del formateador simple de fechas
    }
    
    public Item getItem(){
        return item;
    }
    
    public void setGestor(Gestor gestor){
        this.gestor = gestor;
    }
    
    public void setEstado(EstadoPedido estado){
        this.estadoPedido = estado;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void confirmarPedido(){
        setEstado(EstadoPedido.PEDIDO_CONFIRMADO);
        notificarObservadores(estadoPedido, this);
    }

    public void entregar(){
        setEstado(EstadoPedido.PEDIDO_ENTREGADO);
        notificarObservadores(estadoPedido, this);
    }

    public void finalizar(){
        setEstado(EstadoPedido.PEDIDO_FINALIZADO);
        notificarObservadores(estadoPedido, this);
    }


    public void eliminar(){
        estadoPedido = EstadoPedido.PEDIDO_ELIMINADO;
        notificarObservadores(estadoPedido, this);
    }
    
    public void restarStockDeItem(){
        item.restarStockDeInsumos();
    }

    public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }

    @Override
    public void actualizar(Object evento, Object datos) {

    }
}
