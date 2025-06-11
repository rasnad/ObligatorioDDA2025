package Modelo;

import Modelo.Sistema.Fachada;
import Modelo.Exception.PolloException;

public class Dispositivo {

    Fachada fachada = Fachada.getInstancia();

    int id;
    static int ultimoId = 0;
    boolean estaOcupado = false;
    Cliente clienteAsignado;

    public Dispositivo() {
        this.id = ultimoId++;
    }

    public void asignarCliente(Cliente cliente) {
        this.clienteAsignado = cliente;
        estaOcupado = true;
    }

    public void liberarCliente() {
        this.clienteAsignado = null;
        estaOcupado = false;
    }

    public void loginCliente(int username, String password) throws PolloException {
        if(this.estaOcupado){
            throw new PolloException("Debe primero finalizar el servicio actual.");
        }
        
        fachada.loginCliente(this, Integer.toString(username), password);
    }

}
