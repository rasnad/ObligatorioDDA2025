package Modelo;

import java.util.ArrayList;


public class UnidadProcesadora {
   ArrayList<Gestor> gestores = new ArrayList<>();
   ArrayList<Pedido> pedidos = new ArrayList<>();
   ArrayList<Item> items = new ArrayList<>();

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

   public UnidadProcesadora(ArrayList<Gestor> gestores, ArrayList<Pedido> pedidos, ArrayList<Item> items) {
      this.gestores = gestores;
      this.pedidos = pedidos;
      this.items = items;
   }
}
