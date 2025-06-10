package obligatorio;

import java.util.ArrayList;

public class Gestor extends Usuario {
    UnidadProcesadora unidadProcesadora;
    ArrayList<Pedido> pedidosTomados;
    String userName;
    String trabajo;

    public Gestor(String nombreCompleto, String username, String password, UnidadProcesadora unidad){
        super(nombreCompleto, username, password);
        this.unidadProcesadora = unidad;
    }
 
    public void tomarPedido(Pedido pedido){}
    public void pedidoListo(Pedido pedido){}
    public void pedidoEntregado(Pedido pedido){}

}
