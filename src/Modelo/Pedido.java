package Modelo;

import java.util.Date;

public class Pedido {
    Item item;
    UnidadProcesadora unidadProcesadora;
    Gestor gestor;
    Servicio servicio;
    String comentario;
    Date fechaYHora;    
    //estadoPedido = Estado de pedido nuevo acá, ver patrón state

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
        this.gestor = gestor;
    }
    
    public Servicio getServicio() {
        return servicio;
    }
    
    public void restarStockDeItem(){
        item.restarStockDeInsumos();
    }
    
    /* Esto se hará mediante State
    
    public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }
    
    public void setEstado(EstadoPedido estado){
        this.estadoPedido = estado;
    }

    public void confirmarPedido(){
        setEstado(EstadoPedido.PEDIDO_CONFIRMADO);
    }

    public void entregar(){
        setEstado(EstadoPedido.PEDIDO_ENTREGADO);
    }

    public void finalizar(){
        setEstado(EstadoPedido.PEDIDO_FINALIZADO);
    }


    public void eliminar(){
        estadoPedido = EstadoPedido.PEDIDO_ELIMINADO;
    }
    */
}
