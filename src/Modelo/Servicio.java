package Modelo;

import Modelo.EstadosDePedido.EstadoPedido;
import Modelo.EstadosDePedido.Pedido;
import Modelo.Exception.PolloException;
import Observador.Observable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

public class Servicio extends Observable {
    private ArrayList<Pedido> pedidos = new ArrayList<>();
    private Cliente cliente;
    private Dispositivo dispositivo;
    private Cuenta cuenta = new Cuenta();

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
            if ( item.tieneStock() ){
                p.confirmarPedido();
                p.restarStockDeItem();
            } else {
                pedidosBorrados.add(p);
                p.eliminarPedido();
            }
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

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void calcularCuenta(){
        float subtotal = 0;
        ArrayList<Item> itemsDescontados = new ArrayList<>();
    
        //calcular descuento de cada pedido
        for (Pedido pedido : pedidos){
            float beneficioDelItem = cliente.calcularBeneficioItem( pedido.getItem() );
            if (beneficioDelItem != pedido.getItem().getPrecioUnitario()){
                itemsDescontados.add(pedido.getItem());
            }
            subtotal += beneficioDelItem;
        }
        
        cuenta.setItemsDescontados(itemsDescontados);
        cuenta.setServicioSinDescuento(subtotal); //total con items descontados PERO sin descuento del servicio
        cuenta.setServicioConDescuento( cliente.calcularBeneficioServicio(subtotal) ); //monto final que se cobra al cliente
        
    }
    
    public boolean cobrarTodo() throws PolloException{
        for (Pedido p : pedidos){
            if (! p.cobrarPedido()){
                return false;
            } 
        }
        return true;
    }
    
    public int contarPedidosNoEntregados(){
        int pedidosNoEntregados = 0;
        
        for (Pedido p : pedidos){
            boolean enProceso = p.getEstado().getTipo().equals(EstadoPedido.TipoDeEstado.EN_PROCESO);
            boolean confirmado = p.getEstado().getTipo().equals(EstadoPedido.TipoDeEstado.CONFIRMADO);
            if ( enProceso || confirmado ){
                pedidosNoEntregados++;
            }
        }
        return pedidosNoEntregados;
    }

}
