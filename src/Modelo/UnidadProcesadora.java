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

   public ArrayList<Gestor> getGestores() {
      return gestores;
   }

   public String getNombre(){
       return this.nombre;
   }

   public void loguearGestor(Gestor g){
       gestores.add(g);
   }
   public void desloguearGestor(Gestor g){
       gestores.remove(g);
   }

   public UnidadProcesadora(String nombre) {
      this.nombre = nombre;

   }
}
