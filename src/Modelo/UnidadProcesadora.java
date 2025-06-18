package Modelo;

import static Modelo.EstadosDePedido.EstadoPedido.TipoDeEstado.CONFIRMADO;
import Modelo.EstadosDePedido.Pedido;
import java.util.ArrayList;
import java.util.stream.Collectors;


public class UnidadProcesadora {
   private ArrayList<Gestor> gestores = new ArrayList<>();
   private ArrayList<Pedido> pedidos = new ArrayList<>();
   
   String nombre;

   public UnidadProcesadora(String nombre) {
       this.nombre = nombre;
   }
   
   public String getNombre(){
       return nombre;
   }
   
   public ArrayList<Pedido> getPedidos(){
       return pedidos;
   }
   
   public void agregarPedido(Pedido pedido){
       pedidos.add(pedido);
   }

   public void eliminarPedido(Pedido pedido){
       pedidos.remove(pedido);
   }
   public void tomarPedido(Pedido pedido){

   }
   public void loguearGestor(Gestor g){
       gestores.add(g);
   }

   public void desloguearGestor(Gestor g){
       gestores.remove(g);
   }
   
   public ArrayList<Pedido> obtenerPedidosConfirmados(){
        return pedidos.stream()
            .filter(pedido -> pedido.getTipoDeEstado().equals(CONFIRMADO))
            .collect(Collectors.toCollection(ArrayList::new));
    }

}
