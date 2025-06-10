package obligatorio;

import java.util.ArrayList;

import static obligatorio.EstadoPedido.*;

public class UnidadProcesadora extends ObservableBase implements Observable {
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

   public void avisar(){
      for(Observador o : observadores){
         o.actualizar(PEDIDO_CONFIRMADO, null);
      }
   }

   @Override
   public void actualizar(Object evento, Object datos) {
      if (evento.equals(PEDIDO_CONFIRMADO)) {
         mostrarPedido((Pedido) datos);
      } else if (evento.equals(PEDIDO_FINALIZADO)) {
         mostrarNotificacionFinalizado((Pedido) datos);
      } else if (evento.equals(SERVICIO_FINALIZADO)) {
         liberarCliente();
      }
   }
}
