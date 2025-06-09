package obligatorio;

import java.util.ArrayList;

public class Gestor extends Usuario {
    UnidadProcesadora unidadProcesadora;
    ArrayList<Pedido> pedidosTomados;
    String userName;
    String trabajo;

    public Gestor(String nombreCompleto, String username, String password){
        super(nombreCompleto, username, password);
    }
 
    public void tomarPedido(Pedido pedido){}
    public void pedidoListo(Pedido pedido){}
    public void pedidoEntregado(Pedido pedido){}

}
