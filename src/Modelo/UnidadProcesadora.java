package Modelo;

import Modelo.EstadosDePedido.Pedido;
import java.util.ArrayList;


public class UnidadProcesadora {
   ArrayList<Gestor> gestores = new ArrayList<>();
   ArrayList<Pedido> pedidos = new ArrayList<>();
   ArrayList<Item> items = new ArrayList<>();
   String nombre;

   public UnidadProcesadora() {

   }

   public void cancelarPedido(Pedido pedido){

   }
   public void tomarPedido(Pedido pedido){

   }
   public void loguearGestor(Gestor g){
       gestores.add(g);
   }
   public void desloguearGestor(Gestor g){
       gestores.remove(g);
   }

   public UnidadProcesadora(String nombre, ArrayList<Gestor> gestores, ArrayList<Pedido> pedidos, ArrayList<Item> items) {
      this.nombre = nombre;
      this.gestores = gestores;
      this.pedidos = pedidos;
      this.items = items;
   }
}
