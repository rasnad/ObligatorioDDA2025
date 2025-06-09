package obligatorio;

public class Dispositivo {

    Fachada fachada;
    int id;
    Cliente clienteAsignado;
    boolean estaOcupado;

    public void asignarCliente(Cliente cliente) {
        clienteAsignado = cliente;
        estaOcupado = true;
    }

    public void liberarCliente() {
        clienteAsignado = null;
        estaOcupado = false;
    }

    public void loginCliente(Dispositivo dispositivo, int id, String password) {
        fachada.loginCliente(this, id, password);
    }
}
