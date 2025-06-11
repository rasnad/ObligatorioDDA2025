package Modelo.EstadosDePedido;

import java.util.Date;
import Modelo.Gestor;
import Modelo.Item;
import Modelo.Servicio;
import Modelo.UnidadProcesadora;

public class Pedido {
    Item item;
    UnidadProcesadora unidadProcesadora;
    Gestor gestor;
    Servicio servicio;
    String comentario;
    Date fechaYHora;    
    EstadoPedido estado;

    public Pedido(Item item, UnidadProcesadora unidadProcesadora, Servicio servicio, String comentario) {
        this.item = item;
        this.unidadProcesadora = unidadProcesadora;
        this.servicio = servicio;
        this.comentario = comentario;
        estado = new PedidoNoConfirmado();
        fechaYHora = new Date(); //revisar bien lo del formateador simple de fechas
    }
    
    public Item getItem(){
        return item;
    }
    
    public Servicio getServicio() {
        return servicio;
    }
    
    public void setEstado(EstadoPedido e){
        this.estado = e;
    }
    
    public void setGestor(Gestor gestor){
        this.gestor = gestor;
    }
    
    protected void hacerEliminarPedido(){
        servicio.removerPedido(this);
        this.servicio = null;
    }
    
    protected boolean hacerCobrarPedido(){
        return true;
    }
    
    protected void hacerProcesarPedido(Gestor gestor){
        gestor.tomarPedido(this);
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
