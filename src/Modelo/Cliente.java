package Modelo;

import Modelo.EstadosDePedido.Pedido;
import Modelo.Exception.PolloException;
import Modelo.TiposDeCliente.TipoCliente;

public class Cliente extends Usuario {
    private int id;
    private TipoCliente tipoCliente;
    private Servicio servicio;
    private Dispositivo dispositivo;
    
    public Cliente(int id, TipoCliente tipo, String password, String nombreCompleto){
        super(nombreCompleto, Integer.toString(id), password);
        this.id = id;
        this.tipoCliente = tipo;
    }
    
    public Servicio getServicio(){
        return servicio;
    }
    
    public TipoCliente getTipo(){
        return tipoCliente;
    }
    
    public void setTipo(TipoCliente t){
        this.tipoCliente = t;
    }

    public void asignarDispositivo (Dispositivo dispositivo, Servicio servicio){
        this.dispositivo = dispositivo;
        this.servicio = servicio;
    }
    
    public void eliminarPedido(Pedido pedido) throws PolloException {
        pedido.eliminarPedido();
    }
    
    public void confirmarServicio() throws PolloException{
        servicio.confirmarPedidos();
    }

    public void terminarServicioEnDispositivo(){
        servicio = null;
        dispositivo = null;
    }
    
    public float calcularBeneficioItem(Item item) {
        return tipoCliente.aplicarBeneficioItem(item);
    }
    
    public float calcularBeneficioServicio(float subTotal) {
        return tipoCliente.aplicarBeneficioServicio(subTotal);
    }
}
