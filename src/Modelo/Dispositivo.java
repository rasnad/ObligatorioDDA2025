package Modelo;

import Modelo.Exception.PolloException;

public class Dispositivo {

    int id;
    static int ultimoId = 0;
    boolean estaOcupado = false;
    Cliente clienteAsignado;
    Servicio servicio;

    public Servicio getServicio() {
        return servicio;
    }

    public Dispositivo() {
        this.id = ultimoId++;
    }
    
    public int getId(){
        return id;
    }
    
    public Cliente getCliente(){
        return clienteAsignado;
    }
    
    public boolean getEstaOcupado(){
        return estaOcupado;
    }

    public void puedeLoguearseCliente() throws PolloException {
        if (this.estaOcupado){
            throw new PolloException("Debe primero finalizar el servicio actual.");
        }
    }
    
    public void asignarCliente(Cliente cliente, Servicio servicio) {
        estaOcupado = true;
        this.clienteAsignado = cliente;
        this.servicio = servicio;
    }

    public void liberarClienteDelServicio() {
        clienteAsignado = null;
        servicio = null;
        estaOcupado = false;
    }

}
