package Modelo;

import Modelo.EstadosDePedido.Pedido;
import java.util.ArrayList;


public class UnidadProcesadora {
   ArrayList<Gestor> gestores = new ArrayList<>();
   ArrayList<Pedido> pedidos = new ArrayList<>();
   
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

}
