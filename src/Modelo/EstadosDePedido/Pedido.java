package Modelo.EstadosDePedido;

import Modelo.Exception.PolloException;
import java.util.Date;
import Modelo.Gestor;
import Modelo.Item;
import Modelo.Servicio;
import Modelo.UnidadProcesadora;

public class Pedido {
    private Item item;
    private UnidadProcesadora unidadProcesadora;
    private Gestor gestor;
    private Servicio servicio;
    private String comentario;
    private Date fechaYHora;    
    private EstadoPedido estado = new PedidoNoConfirmado(this);
    private boolean estaFinalizado = false;

    public Pedido(Item item, Servicio servicio, String comentario) {
        this.item = item;
        this.unidadProcesadora = item.getUnidadProcesadora();
        this.servicio = servicio;
        this.comentario = comentario;
        fechaYHora = new Date(); //se sobre-escribe al confirmar, pero tengo miedo de dejar este dato en null tan cerca de la entrega
    }
    
    public void marcarEstaFinalizado(){
        estaFinalizado = true;
    }
    
    public boolean getEstaFinalizado(){
        return estaFinalizado;
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
    
    public Date getFecha(){
        return fechaYHora;
    }
    
    public EstadoPedido getEstado(){
        return estado;
    }
    
    public String getEstadoTexto(){
        return estado.toString();
    }
    
    public EstadoPedido.TipoDeEstado getTipoDeEstado(){
        return estado.getTipo();
    }
    
    protected void setEstado(EstadoPedido e){
        this.estado = e;
        e.setPedido(this);
    }
    
    public void setGestor(Gestor gestor){
        this.gestor = gestor;
    }
    
    protected void hacerEliminarPedido(){
        if (estado.getTipo() != EstadoPedido.TipoDeEstado.NO_CONFIRMADO) {
            this.item.devolverStockDeInsumos();            
            this.getItem().getUnidadProcesadora().eliminarPedido(this);
        }
        servicio.removerPedido(this);
        this.servicio = null;
    }
    
    protected void hacerConfirmarPedido() throws PolloException {
        fechaYHora = new Date();
        this.getItem().getUnidadProcesadora().agregarPedido(this);
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
        return estado.cobrarPedido();
    }
    
    public void finalizarPedido() throws PolloException{
        estado.finalizarPedido();
    }
    
    public void entregarPedido() throws PolloException{
        estado.entregarPedido();
    }

}
