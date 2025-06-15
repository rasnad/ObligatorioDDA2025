package Modelo.EstadosDePedido;

import Modelo.Exception.PolloException;
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

    public Pedido(Item item, Servicio servicio, String comentario) {
        this.item = item;
        this.unidadProcesadora = item.getUnidadProcesadora();
        this.servicio = servicio;
        this.comentario = comentario;
        estado = new PedidoNoConfirmado();
        estado.setPedido(this);
        fechaYHora = new Date(); //revisar bien lo del formateador simple de fechas
    }
    
    public Item getItem(){
        return item;
    }
    
    public String getComentario(){
        return comentario;
    }
    
    public Servicio getServicio() {
        return servicio;
    }
    
    public Gestor getGestor(){
        return gestor;
    }
    
    public String getEstado(){
        return estado.toString();
    }
    
    protected void setEstado(EstadoPedido e){
        this.estado = e;
    }
    
    public void setGestor(Gestor gestor){
        this.gestor = gestor;
    }
    
    protected void hacerEliminarPedido(){
        servicio.removerPedido(this);
        this.servicio = null;
    }
    
    /*
    protected boolean hacerCobrarPedido(){
        return true;
    }
    */
    
    protected void hacerProcesarPedido(Gestor gestor){
        gestor.tomarPedido(this);
    }
    
    public void restarStockDeItem(){
        item.restarStockDeInsumos();
    }
    
    //Manejo del State:
    
    public void procesarPedido(Gestor gestor) throws PolloException{
        estado.procesarPedido(gestor);
    }
    
    public void confirmarPedido() throws PolloException{
        estado.confirmarPedido();
    }
    
    public void eliminarPedido() throws PolloException{
        estado.eliminarPedido();
    }
    
    public boolean cobrarPedido() throws PolloException{
        estado.cobrarPedido();
        return true;
    }
    
    public void finalizarPedido() throws PolloException{
        estado.finalizarPedido();
    }
    
    public void entregarPedido() throws PolloException{
        estado.entregarPedido();
    }
}
